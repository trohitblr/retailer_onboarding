package com.jio.bahubali.mapper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceAddress {

  @Column("address_detail_type")
  private String address_detail_type;

  @Column("address")
  private String address;
}
