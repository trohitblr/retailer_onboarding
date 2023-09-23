package com.jio.bahubali.model.persoanal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetailerAddress {

  private String street;
  private String road;
  private String area;
  private String locality;
  private String pincode;
  private String state;
}
