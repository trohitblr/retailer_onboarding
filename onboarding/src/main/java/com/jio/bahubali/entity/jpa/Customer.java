package com.jio.bahubali.entity.jpa;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {
  @Id private UUID id;

  @Column("order_id")
  private String orderId;

  @Column("customer_id")
  private String customerId;

  @Column("customer_name")
  private String customerName;

  @Column("email_id")
  private String emailId;

  @Column("contact_number")
  private Long contactNumber;

  @Column("membership_id")
  private String membershipId;

  @Column("airmail_id")
  private String airmailId;

  @Column("pancard")
  private String panCard;

  @Column("gstin")
  private String gstIn;

  @Column("loyalty_card_number")
  private String loyaltyCardNumber;
}
