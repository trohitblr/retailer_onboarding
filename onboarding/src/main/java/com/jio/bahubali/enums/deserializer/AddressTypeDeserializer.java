package com.jio.bahubali.enums.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.jio.bahubali.enums.AddressType;
import java.io.IOException;

public class AddressTypeDeserializer extends JsonDeserializer<AddressType> {

  @Override
  public AddressType deserialize(
      JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    String value = jsonParser.getValueAsString();
    if (value != null) {
      for (AddressType enumValue : AddressType.values()) {
        if (enumValue.name().equalsIgnoreCase(value)) {
          return enumValue;
        }
      }
      throw new IllegalArgumentException("No enum constant " + value + " found in Address Type");
    }
    return null;
  }
}
