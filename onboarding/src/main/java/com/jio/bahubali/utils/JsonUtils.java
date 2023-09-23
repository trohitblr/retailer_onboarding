package com.jio.bahubali.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.LinkedHashMap;

public class JsonUtils {

  private static final ObjectMapper mapper = new ObjectMapper();

  public static String toJson(Object object) {
    try {
      return mapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> T fromJson(String json, Class<T> clazz) {
    try {
      return mapper.readValue(json, clazz);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> T convertToJavaObject(LinkedHashMap<String, Object> redisValue, Class<T> clazz)
      throws IOException {
    String json = mapper.writeValueAsString(redisValue);
    return mapper.readValue(json, clazz);
  }
}
