package com.jio.bahubali.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliverySlotRequest implements Serializable {

  private String date;

  @JsonProperty("start_hour")
  private String startHour;

  @JsonProperty("end_hour")
  private String endHour;
}
