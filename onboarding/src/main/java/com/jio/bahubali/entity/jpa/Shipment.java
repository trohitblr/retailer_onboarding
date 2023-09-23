package com.jio.bahubali.entity.jpa;

import com.jio.bahubali.enums.ShipmentStatus;
import com.jio.bahubali.enums.ShipmentType;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("shipment")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment extends BaseEntity {

  @Id private UUID id;

  @Column("shipment_id")
  private String shipmentId;

  @Column("order_id")
  private String orderId;

  @Column("shipment_status")
  private ShipmentStatus status;

  @Column("shipment_type")
  private ShipmentType shipmentType;

  @Column("is_active")
  private Boolean isActive;

  @Column("parent_order_item_id")
  private Long parentOrderItemId;
}
