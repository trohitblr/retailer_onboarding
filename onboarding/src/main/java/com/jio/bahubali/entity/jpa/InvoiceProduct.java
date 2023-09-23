package com.jio.bahubali.entity.jpa;

import com.jio.bahubali.enums.*;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvoiceProduct {

  @Column("order_id")
  private String orderId;

  @Column("sku")
  private String sku; // product id

  @Column("order_item_id")
  private String orderitemId;

  @Column("sale_type")
  private String saleType;

  @Column("order_unit_price")
  private BigDecimal orderUnitPrice;

  @Column("processed_quantity")
  private Integer processedQuantity;

  @Column("quantity")
  private Integer quantity;

  @Column("processed_unit_price")
  private BigDecimal processedUnitPrice;

  @Column("dis_processed_unit_price")
  private BigDecimal disProcessedUnitPrice;

  @Column("promotion_applied")
  private String promotionApplied;

  @Column("shipment_id")
  private String shipmentId;

  @Column("fulfillment_center_id")
  private String fulfillmentCenterId;

  @Column("fulfillment_type")
  private FulfillmentType fulfillmentType;

  @Column("fulfillment_vertical")
  private FulfillmentVertical fulfillmentVertical;

  @Column("group_id")
  private String groupId;

  @Column("content_type")
  private String contentType;

  @Column("product_type")
  private ProductType productType;

  @Column("delivery_date")
  private String deliveryDate;

  @Column("org_unit_mrp")
  private BigDecimal orgUnitMrp;

  @Column("foodstamp")
  private BigDecimal foodstamp;

  @Column("product_category")
  private BigDecimal productCategory;

  @Column("seq_id")
  private String seqId;

  @Column("parent_seq_id")
  private String parentSeqId;

  @Column("is_child")
  private String isChild;

  @Column("parent_sku")
  private String parentSku;

  @Column("transporter_id")
  private String transporterId;

  @Column("sioc_flag")
  private Boolean siocFlag;

  @Column("mode_of_transport")
  private ShipmentType modeOfTransport;

  @Column("images")
  private String image;

  @Column("promotion")
  private String promotion;

  @Column("prm_id")
  private String prmId;

  @Column("cgst")
  private BigDecimal cgst;

  @Column("sgst")
  private BigDecimal sgst;

  @Column("cess")
  private BigDecimal cess;

  @Column("hsn")
  private String hsn;

  @Column("product_distribution_type")
  private ProductDistributionType productDistributionType;

  @Column("product_status")
  private ProductStatus productStatus = ProductStatus.PROCESSED;

  @Column("margin")
  private Float margin;

  @Column("scheme_discount")
  private Float schemeDiscount;
}
