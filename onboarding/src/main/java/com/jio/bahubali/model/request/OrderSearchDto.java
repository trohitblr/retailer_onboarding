package com.jio.bahubali.model.request;

import com.jio.bahubali.enums.ChannelType;
import com.jio.bahubali.enums.OrderType;
import com.jio.bahubali.enums.PaymentMethodType;
import com.jio.bahubali.enums.ShipmentStatus;
import com.jio.bahubali.enums.Status;
import io.micrometer.common.util.StringUtils;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class OrderSearchDto {

  // order info
  @Column("order_id")
  private String orderId;

  // order info
  @Column("channel_order_id")
  private String channelOrderId;

  @Column("created_at")
  private LocalDateTime createdAt;

  @Column("order_status")
  private Status orderStatus;

  @Column("channel_type")
  private ChannelType channelType;

  @Column("order_type")
  private OrderType orderType;

  @Column("final_order_amount")
  private Float finalOrderAmount;

  @Column("payment_method_type")
  private PaymentMethodType paymentMethodType;

  // customer info
  @Column("customer_id")
  private String customerId;

  @Column("customer_name")
  private String customerName;

  @Column("email_id")
  private String emailId;

  @Column("contact_number")
  private Long contactNumber;

  // address info
  @Column("flat_no")
  private String flatNo;

  @Column("floor_no")
  private String floorNo;

  @Column("block_no")
  private String blockNo;

  @Column("building_name")
  private String buildingName;

  @Column("society_name")
  private String societyName;

  @Column("plot_no")
  private String plotNo;

  @Column("street")
  private String street;

  @Column("sector")
  private String sector;

  @Column("area")
  private String area;

  @Column("city")
  private String city;

  @Column("state")
  private String state;

  @Column("pincode")
  private Long pincode;

  @Column("country")
  private String country;

  // order items info
  @Column("order_item_id")
  private String orderItemId;

  @Column("shipment_id")
  private String shipmentId;

  @Column("quantity")
  private int quantity;

  @Column("shipment_status")
  private ShipmentStatus shipmentStatus;

  // product info
  @Column("sku")
  private String sku;

  @Column("org_unit_mrp")
  private Float orgUnitMrp;

  @Column("processed_unit_price")
  private Float processedUnitPrice;

  @Column("fulfillment_center_id")
  private String fulfillmentCenterId;

  @Column("sale_type")
  private String saleType;

  @Column("transporter_id")
  private String transporterId;

  // delivery slot info
  @Column("delivery_date")
  String deliveryDate;

  public String getAddressStringLiteral() {
    return (StringUtils.isNotEmpty(flatNo) ? flatNo + ", " : "")
        + (StringUtils.isNotEmpty(floorNo) ? floorNo + " floor, " : "")
        + (StringUtils.isNotEmpty(blockNo) ? blockNo + ", " : "")
        + (StringUtils.isNotEmpty(buildingName) ? buildingName + ", " : "")
        + (StringUtils.isNotEmpty(societyName) ? societyName + ", " : "")
        + (StringUtils.isNotEmpty(plotNo) ? plotNo + ", " : "")
        + (StringUtils.isNotEmpty(sector) ? sector + ", " : "")
        + (StringUtils.isNotEmpty(area) ? area + ", " : "")
        + (StringUtils.isNotEmpty(city) ? city + ", " : "")
        + (StringUtils.isNotEmpty(state) ? state + ", " : "")
        + (StringUtils.isNotEmpty(country) ? country + "-" : "")
        + (StringUtils.isNotEmpty(String.valueOf(pincode)) ? pincode : "");
  }
}
