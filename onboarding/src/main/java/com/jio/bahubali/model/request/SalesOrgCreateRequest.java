package com.jio.bahubali.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesOrgCreateRequest {
  @JsonProperty("sales_organisation")
  private String salesOrganisation;

  @JsonProperty("sales_document_type")
  private String salesDocumentType;

  @JsonProperty("distribution_channel")
  private String distributionChannel;

  @JsonProperty("division")
  private String division;

  @JsonProperty("created_by")
  private String createdBy;

  @JsonProperty("updated_by")
  private String updatedBy;
}
