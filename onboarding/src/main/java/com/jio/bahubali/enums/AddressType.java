package com.jio.bahubali.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.jio.bahubali.enums.deserializer.AddressTypeDeserializer;

@JsonDeserialize(using = AddressTypeDeserializer.class)
public enum AddressType {
  HOME,
  WORK,
  OTHER,
  Home,
  Work,
  work,
  other
}
