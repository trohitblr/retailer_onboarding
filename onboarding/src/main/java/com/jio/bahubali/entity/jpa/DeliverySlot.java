package com.jio.bahubali.entity.jpa;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("delivery_slot")
@NoArgsConstructor
@AllArgsConstructor
public class DeliverySlot extends BaseEntity {
  @Id private UUID id;

  @Column("order_id")
  private String orderId;

  @Column("product_id")
  private String productId;

  @Column("delivery_date")
  private String deliveryDate;

  @Column("start_hour")
  private String startHour;

  @Column("end_hour")
  private String endHour;
}
