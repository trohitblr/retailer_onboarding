package com.jio.bahubali.service.transformers;

import com.jio.bahubali.model.request.OrderSearchDto;
import com.jio.bahubali.model.response.*;
import com.jio.bahubali.utils.OnboardingUtils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class OrderSearchResponseTransformer {

  @Value("#{${carrier.code.name.mapping}}")
  Map<String, String> carrierCodeNameMapping;

  public Mono<Page<OrderSearchResponseItem>> transform(
      Flux<OrderSearchDto> orderSearchDtoFlux, PageRequest pageRequest) {
    return orderSearchDtoFlux
        .collectList()
        .map(this::transform)
        .flatMapMany(Flux::fromIterable)
        .buffer(pageRequest.getPageSize(), (pageRequest.getPageNumber() + 1))
        .elementAt(pageRequest.getPageNumber(), new ArrayList<>())
        .map(
            orderSearchResponseItems ->
                new PageImpl<>(
                    orderSearchResponseItems, pageRequest, orderSearchResponseItems.size()));
  }

  private List<OrderSearchResponseItem> transform(List<OrderSearchDto> orderSearchDtoList) {

    // creating a map of order id against list of order item-product objects
    Map<String, List<OrderSearchDto>> orderSearchDtoMap = new HashMap<>();
    orderSearchDtoList.forEach(
        orderSearchDto -> {
          List<OrderSearchDto> orderSearchDtoListByOrder =
              orderSearchDtoMap.getOrDefault(orderSearchDto.getOrderId(), new ArrayList<>());
          orderSearchDtoListByOrder.add(orderSearchDto);
          orderSearchDtoMap.put(orderSearchDto.getOrderId(), orderSearchDtoListByOrder);
        });

    List<OrderSearchResponseItem> orderSearchResponseItems = new ArrayList<>();
    orderSearchDtoMap.forEach(
        (orderId, orderSearchDtos) -> {
          OrderSearchDto firstOrderItemProductDto = orderSearchDtos.get(0);
          orderSearchResponseItems.add(
              OrderSearchResponseItem.builder()
                  .order(
                      OrderInfo.builder()
                          .id(firstOrderItemProductDto.getOrderId())
                          .creationDate(
                              firstOrderItemProductDto.getCreatedAt().toLocalDate().toString())
                          .status(firstOrderItemProductDto.getOrderStatus().name())
                          .channelType(firstOrderItemProductDto.getChannelType())
                          .amount(firstOrderItemProductDto.getFinalOrderAmount())
                          .type(firstOrderItemProductDto.getOrderType())
                          .build())
                  .customer(
                      CustomerInfo.builder()
                          .id(firstOrderItemProductDto.getCustomerId())
                          .name(firstOrderItemProductDto.getCustomerName())
                          .emailId(firstOrderItemProductDto.getEmailId())
                          .phoneNumber(firstOrderItemProductDto.getContactNumber())
                          .address(firstOrderItemProductDto.getAddressStringLiteral())
                          .build())
                  .shipments(getShipments(orderSearchDtos))
                  .build());
        });
    return orderSearchResponseItems;
  }

  private List<ShipmentInfo> getShipments(List<OrderSearchDto> orderSearchDtoList) {
    Map<String, List<OrderSearchDto>> shipmentOrderSearchDtosMap = new HashMap<>();
    orderSearchDtoList.forEach(
        orderSearchDto -> {
          List<OrderSearchDto> shipmentOrderSearchDtoList =
              shipmentOrderSearchDtosMap.getOrDefault(
                  orderSearchDto.getShipmentId(), new ArrayList<>());
          shipmentOrderSearchDtoList.add(orderSearchDto);
          shipmentOrderSearchDtosMap.put(
              orderSearchDto.getShipmentId(), shipmentOrderSearchDtoList);
        });

    List<ShipmentInfo> shipments = new ArrayList<>();
    shipmentOrderSearchDtosMap.forEach(
        (shipmentId, orderSearchDtos) -> {
          OrderSearchDto firstOrderSearchDto = orderSearchDtos.get(0);
          if (!Objects.isNull(firstOrderSearchDto.getShipmentId())) {
            List<ShipmentArticleInfo> shipmentArticles = extractShipmentArticles(orderSearchDtos);
            shipments.add(
                ShipmentInfo.builder()
                    .shipmentId(shipmentId)
                    .creationDate(firstOrderSearchDto.getCreatedAt().toLocalDate().toString())
                    .orderId(firstOrderSearchDto.getOrderId())
                    .shipmentStatus(orderSearchDtos.get(0).getShipmentStatus())
                    .deliveryDate(
                        Objects.isNull(firstOrderSearchDto.getDeliveryDate())
                            ? null
                            : LocalDate.parse(
                                    firstOrderSearchDto.getDeliveryDate(),
                                    DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                                .toString())
                    .totalAmount(getTotalShipmentAmount(shipmentArticles))
                    .invoiceAmount(getInvoiceShipmentAmount(shipmentArticles))
                    .transactionId(firstOrderSearchDto.getChannelOrderId())
                    .transactionDate(firstOrderSearchDto.getCreatedAt().toLocalDate().toString())
                    .paymentMode(firstOrderSearchDto.getPaymentMethodType())
                    .storeId(firstOrderSearchDto.getFulfillmentCenterId())
                    .carrierName(carrierCodeNameMapping.get(firstOrderSearchDto.getTransporterId()))
                    //    .shipmentArticles(shipmentArticles)
                    .build());
          }
        });
    return shipments;
  }

  private List<ShipmentArticleInfo> extractShipmentArticles(
      List<OrderSearchDto> orderSearchDtoList) {
    List<ShipmentArticleInfo> shipmentArticleInfoList = new ArrayList<>();
    Map<String, List<OrderSearchDto>> articleOrderSearchDtosMap = new HashMap<>();

    orderSearchDtoList.forEach(
        orderSearchDto -> {
          List<OrderSearchDto> articleOrderSearchDtoList =
              articleOrderSearchDtosMap.getOrDefault(orderSearchDto.getSku(), new ArrayList<>());
          articleOrderSearchDtoList.add(orderSearchDto);
          articleOrderSearchDtosMap.put(orderSearchDto.getSku(), articleOrderSearchDtoList);
        });

    articleOrderSearchDtosMap.forEach(
        (articleId, orderSearchDtos) -> {
          OrderSearchDto firstOrderSearchDto = orderSearchDtos.get(0);
          shipmentArticleInfoList.add(
              ShipmentArticleInfo.builder()
                  .articleId(firstOrderSearchDto.getSku())
                  .description(firstOrderSearchDto.getSaleType())
                  .maximumRetailPrice(firstOrderSearchDto.getOrgUnitMrp())
                  .offerPrice(firstOrderSearchDto.getProcessedUnitPrice())
                  .quantity(getArticleTotalQuantity(orderSearchDtos))
                  .storeId(firstOrderSearchDto.getFulfillmentCenterId())
                  .carrierName(carrierCodeNameMapping.get(firstOrderSearchDto.getTransporterId()))
                  .build());
        });
    return shipmentArticleInfoList;
  }

  private float getTotalShipmentAmount(List<ShipmentArticleInfo> shipmentArticles) {
    float amount = 0.0F;
    for (ShipmentArticleInfo shipmentArticle : shipmentArticles) {
      amount += shipmentArticle.getMaximumRetailPrice() * shipmentArticle.getQuantity();
    }
    return amount;
  }

  private Float getInvoiceShipmentAmount(List<ShipmentArticleInfo> shipmentArticles) {
    float amount = 0.0F;
    for (ShipmentArticleInfo shipmentArticle : shipmentArticles) {
      amount += shipmentArticle.getOfferPrice() * shipmentArticle.getQuantity();
    }
    return amount;
  }

  private int getArticleTotalQuantity(List<OrderSearchDto> orderSearchDtos) {
    int quantity = 0;
    for (OrderSearchDto orderSearchDto : orderSearchDtos) {
      quantity += orderSearchDto.getQuantity();
    }
    return quantity;
  }

  public static Mono<List<DmsOrderInfoResponse>> dmsOrderTransformer(
      Flux<DMSOrderInfo> dMSOrderInfo) {
    return dMSOrderInfo
        .groupBy(DMSOrderInfo::getOrderId)
        .flatMap(OrderSearchResponseTransformer::convertGroupedOrderInfoToOrderResponse)
        .switchIfEmpty(Flux.empty())
        .collectSortedList(
            (order1, order2) ->
                OnboardingUtils.dateConverter(order2.getCreatedAt())
                    .compareTo(OnboardingUtils.dateConverter(order1.getCreatedAt())));
  }

  private static Mono<DmsOrderInfoResponse> convertGroupedOrderInfoToOrderResponse(
      Flux<DMSOrderInfo> groupedFlux) {
    return groupedFlux
        .collectList()
        .map(OrderSearchResponseTransformer::convertListOrderInfoToOrderResponse);
  }

  private static DmsOrderInfoResponse convertListOrderInfoToOrderResponse(
      List<DMSOrderInfo> format1List) {
    DmsOrderInfoResponse dmsOrderInfoResponse = new DmsOrderInfoResponse();
    Map<String, List<DMSOrderInfo>> groupByOrderId =
        format1List.stream().collect(Collectors.groupingBy(DMSOrderInfo::getOrderId));

    List<DmsOrderItemInfo> orderItems = new ArrayList<>();
    for (Map.Entry<String, List<DMSOrderInfo>> entry : groupByOrderId.entrySet()) {
      String orderId = entry.getKey();
      List<DMSOrderInfo> orderItemsData = entry.getValue();

      DMSOrderInfo firstFormat1 = orderItemsData.get(0);
      dmsOrderInfoResponse.setOrderId(orderId);
      dmsOrderInfoResponse.setGrossTotal(firstFormat1.getGrossTotal());
      dmsOrderInfoResponse.setTotalProductSavings(firstFormat1.getTotalProductSavings());
      dmsOrderInfoResponse.setStatus(firstFormat1.getOrderStatus());
      dmsOrderInfoResponse.setCreatedAt(firstFormat1.getCreatedAt());
      dmsOrderInfoResponse.setApprovalStatus(firstFormat1.getApprovalStatus());
      dmsOrderInfoResponse.setApprovesId(firstFormat1.getApprovesId());
      dmsOrderInfoResponse.setFosId(firstFormat1.getFosId());
      dmsOrderInfoResponse.setBeatId(firstFormat1.getBeatId());
      dmsOrderInfoResponse.setTotalOrderDiscount(firstFormat1.getTotalOrderDiscount());
      dmsOrderInfoResponse.setFinalOrderAmount(firstFormat1.getFinalOrderAmount());
      dmsOrderInfoResponse.setBuyerStoreId(firstFormat1.getBuyerStoreId());
      dmsOrderInfoResponse.setBuyerPrmId(firstFormat1.getBuyerPrmId());
      dmsOrderInfoResponse.setSellerPrmId(firstFormat1.getSellerPrmId());
      dmsOrderInfoResponse.setParentOrderId(firstFormat1.getParentOrderId());
      dmsOrderInfoResponse.setReturnExpire(firstFormat1.getReturnExpire());

      List<DmsOrderItemInfo> items =
          orderItemsData.stream()
              .map(OrderSearchResponseTransformer::convertSingleFormat1ToOrderItem)
              .collect(Collectors.toList());

      orderItems.addAll(items);
    }

    dmsOrderInfoResponse.setOrderItems(orderItems);
    return dmsOrderInfoResponse;
  }

  private static DmsOrderItemInfo convertSingleFormat1ToOrderItem(DMSOrderInfo dMSOrderInfo) {
    DmsOrderItemInfo dmsOrderItemInfo = new DmsOrderItemInfo();
    dmsOrderItemInfo.setOrderItemId(dMSOrderInfo.getOrderItemId());
    dmsOrderItemInfo.setSku(dMSOrderInfo.getSku());
    dmsOrderItemInfo.setDescription(dMSOrderInfo.getDescription());
    dmsOrderItemInfo.setUnitMrp(dMSOrderInfo.getUnitMrp());
    dmsOrderItemInfo.setDiscountedPrice(dMSOrderInfo.getDiscountedPrice());
    dmsOrderItemInfo.setImageUrl(dMSOrderInfo.getImages());
    dmsOrderItemInfo.setQuantity(dMSOrderInfo.getQuantity());
    dmsOrderItemInfo.setProcessedUnitPrice(dMSOrderInfo.getProcessedUnitPrice());
    dmsOrderItemInfo.setItemId(dMSOrderInfo.getItemId());
    dmsOrderItemInfo.setItemSize(dMSOrderInfo.getItemSize());
    dmsOrderItemInfo.setLadderPriceTag(dMSOrderInfo.getLadderPriceTag());
    dmsOrderItemInfo.setPriceTag(dMSOrderInfo.getPriceTag());
    dmsOrderItemInfo.setProductDistributionType(dMSOrderInfo.getProductDistributionType());
    dmsOrderItemInfo.setProductStatus(dMSOrderInfo.getProductStatus());

    return dmsOrderItemInfo;
  }
}
