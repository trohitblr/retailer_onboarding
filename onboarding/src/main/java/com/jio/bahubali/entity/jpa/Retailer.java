package com.jio.bahubali.entity.jpa;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "retailer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Retailer extends BaseEntity {

  @Id private UUID id;

  @Column("prm_id")
  private String prmId;

  @Column("name")
  private String name;

  @Column("storeName")
  private String storeName;

  @Column("mobile")
  private String mobile;

  @Column("addressFirstLine")
  private String addressFirstLine;

  @Column("addressSecondLine")
  private String addressSecondLine;

  @Column("addressCity")
  private String addressCity;

  @Column("addressState")
  private String addressState;

  @Column("addressPinCode")
  private String addressPinCode;

  @Column("channelType")
  private String channelType;

  @Column("gstin")
  private String gstin;

  @Column("type")
  private String type;

  @Column("loyaltyTier")
  private String loyaltyTier;
}
