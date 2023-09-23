package com.jio.bahubali.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jio.bahubali.enums.ChannelType;
import java.util.List;
import lombok.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderFetchRequest {

  private ChannelType channelType;

  @JsonProperty("order_Ids")
  private List<String> orderIds;

  @JsonProperty("fos_Ids")
  private List<String> fosId;

  @JsonProperty("prm_id")
  private String prmId;

  @JsonProperty("beat_ids")
  private List<String> beatIds;

  @JsonProperty("from_date_time")
  private String fromDate;

  @JsonProperty("to_date_time")
  private String toDate;
}
