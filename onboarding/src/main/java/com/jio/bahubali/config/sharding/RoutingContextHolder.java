package com.jio.bahubali.config.sharding;

public final class RoutingContextHolder {

  private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

  public static void setRoutingKey(String routingKey) {
    contextHolder.set(routingKey);
  }

  public static String getRoutingKey() {
    return contextHolder.get();
  }

  public static void clearRoutingKey() {
    contextHolder.remove();
  }
}
