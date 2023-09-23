package com.jio.bahubali.entity.jpa;

import com.jio.bahubali.enums.OrderItemStatus;
import com.jio.bahubali.enums.ShipmentStatus;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("order_items")
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems extends BaseEntity {

  @Id private UUID id;

  @Column("order_item_id")
  private String orderItemId;

  @Column("order_id")
  private String orderId;

  @Column("product_id")
  private String productId;

  @Column("shipment_id")
  private String shipmentId;

  @Column("parent_order_id")
  private String parentOrderId;

  @Column("serial_number")
  private String serialNumber;

  @Column("quantity")
  private int quantity;

  @Column("order_item_status")
  private OrderItemStatus orderItemStatus;

  @Column("shipment_status")
  private ShipmentStatus shipmentStatus;
}
