package com.jio.bahubali.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jio.bahubali.constants.CommonConstants;
import com.jio.bahubali.enums.*;
import com.jio.bahubali.model.response.ApprovesDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class OrderRequest implements Serializable {

  @JsonProperty("temp_order_id")
  @NotBlank(message = CommonConstants.INVALID_TEMP_ORDER_ID)
  @NotNull(message = CommonConstants.INVALID_TEMP_ORDER_ID)
  private String channelOrderId;

  private String orderId;

  @JsonProperty("order_type")
  @NotNull(message = "Invalid order_type")
  private OrderType orderType;

  @JsonProperty("channel_type")
  private ChannelType channelType;

  @JsonProperty("membership_id")
  private String membershipId;

  @JsonProperty("fulfillment_center_id")
  private String fulfillmentCenterId;

  @JsonProperty("fulfillment_Type")
  private FulfillmentType fulfillmentType;

  @JsonProperty("gross_total")
  private BigDecimal grossTotal;

  @JsonProperty("total_product_discount")
  private BigDecimal totalProductDiscount;

  @JsonProperty("total_order_discount")
  private BigDecimal totalOrderDiscount;

  @JsonProperty("total_savings")
  private BigDecimal totalSavings;

  @JsonProperty("delivery_charges")
  private BigDecimal deliveryCharges;

  @JsonProperty("final_order_amount")
  private BigDecimal finalOrderAmount;

  private String coupon;

  @JsonProperty("Source")
  private SourceType source;

  @JsonProperty("order_created_by")
  private String orderCreatedBy;

  @JsonProperty("mixed_cart")
  private Boolean mixedCart;

  @JsonProperty("whatsapp_notification")
  private Boolean whatsappNotification;

  @JsonProperty("order_created_date")
  private String orderCreatedDate;

  private Status status;

  /* Doubt*/
  private Boolean pickType;

  @JsonProperty("Cashback")
  private List<String> cashback;

  @JsonProperty("ship_type")
  private String shipType;

  @JsonProperty("SLOT_REF_NO")
  private String slotRefNo;

  @JsonProperty("ORDER_REF")
  private String orderReference;

  @JsonProperty("TYPE_VALUE")
  private String typeValue;

  // Customer details
  @JsonProperty("customer_name")
  private String customerName;

  @JsonProperty("email_id")
  private String emailId;

  @JsonProperty("contact_number")
  private String contactNumber;

  @JsonProperty("customer_id")
  private String customerId;

  @JsonProperty("airmail_id")
  private String airmailId;

  @JsonProperty("pancard")
  private String panCard;

  @JsonProperty("gstin")
  private String gstIn;

  @JsonProperty("loyalty_card_number")
  private String loyaltyCardNumber;

  /** Fynd */
  @JsonProperty("payment_method")
  private PaymentMethodType paymentMethod;

  @JsonProperty("billing_address")
  @NotNull(message = "Invalid billing address")
  private AddressRequest billingAddress;

  @JsonProperty("shipping_address")
  @NotNull(message = "Invalid shipping address")
  private AddressRequest shippingAddress;

  @JsonProperty("payment_methods")
  private List<PaymentMethodRequest> paymentMethods;

  @NotNull(message = "Products cannot be null")
  private List<ProductRequest> products;

  // @JsonProperty("delivery_slot")
  // @NotNull(message = "Invalid delivery slot")
  // private DeliverySlotRequest deliverySlotRequest;

  @JsonProperty("fos_id")
  private String fosId;

  @JsonProperty("beat_id")
  private String beatId;

  @JsonProperty("prm_id")
  private String prmId;

  @JsonProperty("seller_prm_id")
  private String sellerPrmId;

  @JsonProperty("buyer_prm_id")
  private String buyerPrmId;

  @JsonProperty("buyer_store_id")
  private String buyerStoreId;

  @JsonProperty("latitude")
  private String latitude;;

  @JsonProperty("longitude")
  private String longitude;

  @JsonProperty("parent_order_id")
  private String parentOrderId;

  @JsonProperty("approves_list")
  private List<ApprovesDTO> approvesList;
}
