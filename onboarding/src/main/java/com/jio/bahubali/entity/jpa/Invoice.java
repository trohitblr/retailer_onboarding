package com.jio.bahubali.entity.jpa;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.Lob;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("invoice")
@Data
@AllArgsConstructor
public class Invoice {

  @Id private UUID id;

  @Column("channel_order_id")
  private String channelOrderId;

  @Column("order_id")
  private String orderId;

  @Column("invoice_number")
  private String invoiceNumber;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @Column("invoice_date")
  private LocalDateTime invoiceDate;

  @Column("order_status")
  private String orderStatus;

  @Column("final_order_amount")
  private Float finalOrderAmount;

  @Column("total_order_discount")
  private Float totalOrderDiscount;

  @Column("buyer_store_id")
  private String buyerStoreId;

  @Column("ship_to")
  private String shipTo;

  @Column("bill_to")
  private String billTo;

  @Column("seller_prm_id")
  private String sellerPrmId;

  @Lob private byte[] content;

  @Column("channel_type")
  private String channelType;

  @Column("pick_list_content")
  @Lob
  private byte[] pickListContent;
}
