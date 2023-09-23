package com.jio.bahubali.entity.jpa;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("sales_organisation_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrgInfo extends BaseEntity {

  @Id private UUID id;

  @Column("sales_organisation")
  private String salesOrganisation;

  @Column("sales_document_type")
  private String salesDocumentType;

  @Column("distribution_channel")
  private String distributionChannel;

  @Column("division")
  private String division;

  @Column("status")
  private String status;

  public boolean isEmpty() {
    return this.id == null;
  }
}
