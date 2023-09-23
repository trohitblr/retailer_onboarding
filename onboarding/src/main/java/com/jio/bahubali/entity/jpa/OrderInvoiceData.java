package com.jio.bahubali.entity.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInvoiceData {

  @Column("channel_order_id")
  private String channelOrderId;

  @Column("order_id")
  private String orderId;

  @Column("order_status")
  private String orderStatus;

  @Column("final_order_amount")
  private Float finalOrderAmount;

  @Column("total_order_discount")
  private Float totalOrderDiscount;

  @Column("buyer_store_id")
  private String buyerStoreId;

  @Column("channel_type")
  private String channelType;
}
