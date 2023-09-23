package com.jio.bahubali.model.response.wrapper;

import lombok.Data;

@Data
public class ResponseWrapper {

  private long timestamp;

  private Status status;

  private Object data;

  public enum Status {
    SUCCESS,
    ERROR
  }
}
