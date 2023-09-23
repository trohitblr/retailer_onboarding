package com.jio.bahubali.enums;

public enum ErrorCode {
  BAD_REQUEST(404, "Bad Request"),
  INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
  ORDER_CREATION_FAILED(1001, "Order creation failed");

  private final int code;
  private final String message;

  ErrorCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
