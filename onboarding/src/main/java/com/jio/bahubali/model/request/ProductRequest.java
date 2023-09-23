package com.jio.bahubali.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jio.bahubali.enums.FulfillmentType;
import com.jio.bahubali.enums.FulfillmentVertical;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequest implements Serializable {

  private String sku;

  private String orderItemId;

  @JsonProperty("sale_type")
  private String saleType;

  @JsonProperty("order_unit_price")
  private BigDecimal orderUnitPrice;

  @JsonProperty("processed_quantity")
  private Integer processedQuantity;

  @JsonProperty("quantity")
  private Integer quantity;

  @JsonProperty("processed_unit_price")
  private BigDecimal processedUnitPrice;

  @JsonProperty("Dis_processed_unit_price")
  private BigDecimal disProcessedUnitPrice;

  @JsonProperty("promotion_applied")
  private String promotionApplied;

  @JsonProperty("shipmentid")
  private String shipmentId;

  @JsonProperty("fulfillment_center_id")
  private String fulfillmentCenterId;

  @JsonProperty("fulfillment_Type")
  private FulfillmentType fulfillmentType;

  @JsonProperty("fulfillment_Vertical")
  private FulfillmentVertical fulfillmentVertical;

  @JsonProperty("GroupID")
  private String groupId;

  @JsonProperty("PrescriptionImage")
  private String prescriptionImage;

  @JsonProperty("ContentType")
  private String contentType;

  @JsonProperty("product_type")
  private String productType;

  @JsonProperty("org_unit_mrp")
  private BigDecimal orgUnitMrp;

  @JsonProperty("foodstamp")
  private BigDecimal foodStamp;

  @JsonProperty("product_category")
  private BigDecimal productCategory;

  @JsonProperty("seqid")
  private String seqId;

  @JsonProperty("parentseqid")
  private String parentSeqId;

  @JsonProperty("IsChild")
  private String isChild;

  @JsonProperty("Parentsku")
  private String parentSku;

  @JsonProperty("isHomeDelivery")
  private Boolean isHomeDelivery;

  @JsonProperty("gift_article")
  private Integer giftArticle;

  @JsonProperty("merchantId")
  private String merchantId;

  private BigDecimal margin;

  @JsonProperty("margin_percentage")
  private BigDecimal marginPercentage;

  @JsonProperty("merchantGSTIN")
  private String merchantGSTIN;

  @JsonProperty("TransporterId")
  private String transporterId;

  @JsonProperty("SIOCFlag")
  private Boolean siocFlag;

  @JsonProperty("ModeOfTransport")
  private String modeOfTransport;

  private ImagesRequest images;

  // private String promotion;

  @JsonProperty("PRMID")
  private String prmId;

  @JsonProperty("DCID")
  private String dcId;

  @JsonProperty("IMEIvalidation")
  private Boolean imeiValidation;

  @JsonProperty("coupon_code")
  private String couponCode;

  @JsonProperty("promoGroup")
  private String promoGroup;

  @JsonProperty("expiry_date")
  private LocalDateTime expiryDate;

  @JsonProperty("country_of_origin")
  private String countryOfOrigin;

  @JsonProperty("coupon_discount")
  private String couponDiscount;

  @JsonProperty("LINE_NO")
  private String lineNo;

  @JsonProperty("LINE_VAL")
  private String lineVal;

  @JsonProperty("ITEM_NO")
  private String itemNo;

  @JsonProperty("ITEM_VAL")
  private String itemVal;

  @JsonProperty("ITEM_DETAILS")
  private String itemDetails;

  @JsonProperty("REF_NO")
  private String refNo;

  @JsonProperty("REF_VAL")
  private String refVal;

  @JsonProperty("delivery_slot")
  private DeliverySlotRequest deliverySlotRequest;

  @JsonProperty("uom")
  private String unitOfMeasure;

  @JsonProperty("req_dlvry_dt")
  private String requestDeliveryDate;

  @JsonProperty("meta")
  private ProductMetaRequest productMetaRequest;
}
