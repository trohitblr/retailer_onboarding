package com.jio.bahubali.constants;

import org.springframework.beans.factory.annotation.Value;

public abstract class ConfigConstants {

  @Value("${spring.kafka.topic.GROUP_ID}")
  public static final String GROUP_ID = "group_id";

  @Value("${spring.kafka.topic.ORDER_REQUEST_TOPIC}")
  public static final String ORDER_REQUEST_TOPIC = "ORDER_REQUEST_TOPIC";
}
