package com.jio.bahubali.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.jio.bahubali.enums.deserializer.ChannelTypeDeserializer;
import lombok.Getter;

@JsonDeserialize(using = ChannelTypeDeserializer.class)
@Getter
public enum ChannelType {
  RCPL("RCP"),
  ASP("FY"),
  B2B("BB");

  private final String prefix;

  ChannelType(String prefix) {
    this.prefix = prefix;
  }
}
