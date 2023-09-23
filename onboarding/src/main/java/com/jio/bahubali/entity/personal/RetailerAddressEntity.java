package com.jio.bahubali.entity.personal;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "retailer_address")
public class RetailerAddressEntity {
  @Id private int id;

  @Column("retailer_id")
  private int retailerId;

  private String street;
  private String road;
  private String area;
  private String locality;
  private String pincode;
  private String state;

  // Constructors, getters, and setters
}
