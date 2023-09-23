package com.jio.bahubali.entity.jpa;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("invoice_sequence")
public class InvoiceSequence {

  @Id
  @Column("sequence_name")
  private String sequenceName;

  @Column("next_value")
  private Long nextValue;
}
