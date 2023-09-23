package com.jio.bahubali.enums.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.jio.bahubali.enums.ChannelType;
import java.io.IOException;

public class ChannelTypeDeserializer extends JsonDeserializer<ChannelType> {

  @Override
  public ChannelType deserialize(
      JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    String value = jsonParser.getValueAsString();
    if (value != null) {
      for (ChannelType enumValue : ChannelType.values()) {
        if (enumValue.name().equalsIgnoreCase(value)) {
          return enumValue;
        }
      }
      throw new IllegalArgumentException("No enum constant " + value + " found in Channel Type");
    }
    return null;
  }
}
