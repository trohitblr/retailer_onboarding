package com.jio.bahubali.model.persoanal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetailerMedia {

  private int id;
  private int retailerId;
  private int retailerMediaId;
  private String retailerImageUrl;
  private int retailerVideoUrl;
  private Date createdAt;
  private Date updatedAt;
}
