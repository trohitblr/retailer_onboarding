package com.jio.bahubali.entity.jpa;

import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class Balance {

  @Id private UUID id;

  @Column("member_id")
  private String memberId;

  @Column("order_id")
  private String orderId;

  private Long balance;
}
