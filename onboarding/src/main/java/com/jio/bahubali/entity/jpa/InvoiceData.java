package com.jio.bahubali.entity.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceData {

  @Column("invoice_number")
  private String invoiceNumber;

  @Column("channel_order_id")
  private String channelOrderId;

  @Column("invoice_date")
  private String invoiceDate;

  @Column("final_order_amount")
  private String finalOrderAmount;

  @Column("total_order_discount")
  private String totalOrderDiscount;

  @Column("ship_to")
  private String shipTo;

  @Column("bill_to")
  private String billTo;

  @Column("buyer_name")
  private String buyerName;

  @Column("buyer_detail")
  private String buyerDetail;

  @Column("seller_name")
  private String sellerName;

  @Column("seller_detail")
  private String sellerDetail;

  @Column("seller_place")
  private String sellerPlace;

  @Column("seller_mob")
  private String sellerMob;

  @Column("seller_gstin")
  private String sellerGstin;

  @Column("order_created_at")
  private String orderCreatedAt;

  @Column("seller_store")
  private String sellerStore;

  @Column("buyer_store_name")
  private String buyerStoreName;

  @Column("buyer_prm_id")
  private String buyerPrmId;

  @Column("buyer_gstin")
  private String buyerGstin;

  @Column("buyer_mob")
  private String buyerMob;

  @Column("seller_prm_id")
  private String sellerPrmId;

  @Column("buyer_place")
  private String buyerPlace;
}
