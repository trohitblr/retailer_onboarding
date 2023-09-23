package com.jio.bahubali.model.persoanal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetailerMeta {

  private String gstNumber;
  private String storeCategory;
  private String storeSubCategory;
  private float lat;
  private float lon;
  private LocalDateTime storeStartDate;
  private LocalDateTime storeOpeningStartHours;
  private LocalDateTime storeOpeningClosingHours;
  private String storeDescription;
  private String storeSpeciality;
}
