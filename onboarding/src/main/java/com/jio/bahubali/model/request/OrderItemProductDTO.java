package com.jio.bahubali.model.request;

import com.jio.bahubali.enums.*;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class OrderItemProductDTO {
  @Column("order_id")
  private String orderId;

  @Column("channel_order_id")
  private String channelOrderId;

  @Column("sku")
  private String sku;

  @Column("quantity")
  private Integer quantity;

  @Column("order_item_id")
  private String orderItemId;

  @Column("orderitem_id")
  private UUID orderitemUid;

  @Column("product_id")
  private String productId;

  /* @Column("serial_number")
  private String serialNumber;

  @Column("delivery_date")
  private String deliveryDate;

  @Column("product_category")
  private Float productCategory;*/

  @Column("seq_id")
  private String seqId;

  @Column("parent_seq_id")
  private String parentSeqId;

  @Column("parent_sku")
  private String parentSku;

  @Column("transporter_id")
  private String transporterId;

  @Column("sioc_flag")
  private Boolean siocFlag;

  @Column("prm_id")
  private String prmId;

  @Column("mode_of_transport")
  private ShipmentType modeOfTransport;

  @Column("channel_type")
  private ChannelType channel_type;

  @Column("product_type")
  private ProductType product_type;
}
