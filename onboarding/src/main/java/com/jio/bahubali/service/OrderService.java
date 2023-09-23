/*
package com.jio.bahubali.service;

import com.jio.bahubali.entity.jpa.Order;
import com.jio.bahubali.model.request.*;
import com.jio.bahubali.model.response.DmsOrderInfoResponse;
import com.jio.bahubali.model.response.FalconPaginatedResponseDTO;
import com.jio.bahubali.model.response.OrderSearchResponseItem;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import reactor.core.publisher.Mono;

public interface OrderService {

  void add(Order order);

  Mono<Order> createOrder(OrderRequest orderCreateRequest);

  Mono<List<DmsOrderInfoResponse>> fetchOrders(OrderFetchRequest orderFetchRequest);

  Mono<List<DmsOrderInfoResponse>> updateOrderStatus(OrderApproveRequest orderApproveRequest);

  Mono<Page<OrderSearchResponseItem>> searchOrders(
      OrderSearchRequest orderSearchRequest, PageRequest pageRequest);

  byte[] downloadData(OrderDownloadRequest orderDownloadRequest);

  Mono<Order> modifyOrderAndProductItem(DMSEditOrderRequest editOrderRequest);

  Mono<FalconPaginatedResponseDTO<List<DmsOrderInfoResponse>>> fetchApprovesOrder(
      FetchApprovesOrdersRequest fetchApprovesOrdersRequest, PageRequest pageRequest);

  Mono<FalconPaginatedResponseDTO<List<DmsOrderInfoResponse>>> fetchBuyerOrder(
      FetchBuyerOrders fetchBuyerOrders, PageRequest pageRequest);

  Mono<Order> cancelOrderByBuyer(OrderUpdateRequest orderUpdateRequest);
}
*/
