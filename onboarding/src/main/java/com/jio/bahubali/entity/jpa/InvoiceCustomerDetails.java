package com.jio.bahubali.entity.jpa;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("invoice_cust_details")
public class InvoiceCustomerDetails {

  @Id private UUID id;

  @Column("invoice_number")
  private String invoiceNumber;

  @Column("channel_order_id")
  private String channelOrderId;

  @Column("buyer_name")
  private String buyerName;

  @Column("buyer_detail")
  private String buyerDetails;

  @Column("buyer_store_name")
  private String buyerStoreName;

  @Column("seller_name")
  private String sellerName;

  @Column("seller_detail")
  private String sellerDetails;

  @Column("seller_place")
  private String sellerPlace;

  @Column("seller_mob")
  private String sellerMob;

  @Column("seller_gstin")
  private String sellerGstin;

  @Column("seller_store")
  private String sellerStore;

  @Column("buyer_prm_id")
  private String buyerPrmId;

  @Column("seller_prm_id")
  private String sellerPrmId;

  @Column("buyer_gstin")
  private String buyerGstin;

  @Column("buyer_mob")
  private String buyerMob;

  @Column("buyer_place")
  private String buyerPlace;
}
