package com.jio.bahubali.entity.jpa;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.jio.bahubali.enums.ApprovesRoleType;
import com.jio.bahubali.enums.OrderApprovalStatus;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("order_approval")
public class OrderApproval extends BaseEntity {

  @Id private UUID id;

  @Column("approves_id")
  private String approvesId;

  @Column("approves_name")
  private String approvesName;

  @Column("channel_order_id")
  private String orderId;

  @Column("role_type")
  private ApprovesRoleType roleType;

  @Column("approval_level")
  private Integer approvalLevel;

  @Column("status")
  private OrderApprovalStatus status = OrderApprovalStatus.PENDING;

  @Column("comment")
  private String comment;

  @Column("approved_at")
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  private LocalDateTime approvedAt;
}
