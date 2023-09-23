package com.jio.bahubali.entity.jpa;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("invoice_lines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceLineItem {
  @Id private UUID id;

  @Column("sku")
  private String sku;

  @Column("processed_quantity")
  private Integer processedQuantity;

  @Column("org_unit_mrp")
  private Float orgUnitMrp;

  @Column("order_unit_price")
  private Float orderUnitPrice;

  @Column("processed_unit_price")
  private Float processedUnitPrice;

  @Column("invoice_number")
  private String invoiceNumber;

  @Column("cgst")
  private Float cgst = 0f;

  @Column("sgst")
  private Float sgst = 0f;

  @Column("cgst_amount")
  private BigDecimal cgstAmount;

  @Column("sgst_amount")
  private BigDecimal sgstAmount;

  @Column("sale_type")
  private String saleType;

  @Column("product_distribution_type")
  private String productDistributionType;

  @Column("cess")
  private Float cess = 0f;

  @Column("cess_amount")
  private BigDecimal cessAmount;

  @Column("hsn")
  private String hsn = "12345";

  @Column("igst")
  private Float igst = 0f;

  @Column("igst_amount")
  private BigDecimal igstAmount;

  @Transient private BigDecimal unitItemBasePrice;

  @Transient private BigDecimal finalItemPrice;

  @Transient private BigDecimal finalItemPriceWithTax;

  @Column("product_discount")
  private Float productDiscount = 0f;

  @Transient private BigDecimal finalItemPricePostDiscount;

  @Transient private BigDecimal totalCgstAmount;

  @Transient private BigDecimal totalSgstAmount;

  @Transient private BigDecimal totalCessAmount;

  @Column("margin")
  private Float margin;

  @Column("scheme_discount")
  private Float schemeDiscount;

  @Transient private BigDecimal totalSchemeDiscount;

  @Transient private BigDecimal finalItemPriceWithOutTax;
}
