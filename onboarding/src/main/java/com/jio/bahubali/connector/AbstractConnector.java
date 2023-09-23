package com.jio.bahubali.connector;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public abstract class AbstractConnector {
  public HttpHeaders getHeader() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return headers;
  }

  public <E> HttpEntity<Object> getEntity(E entity) {
    HttpHeaders headers = getHeader();
    headers.set("Authorization", "Basic " + "ZmFsY29uOkJyaE1AJHRyQA==");
    return new HttpEntity<Object>(entity, headers);
  }
}
