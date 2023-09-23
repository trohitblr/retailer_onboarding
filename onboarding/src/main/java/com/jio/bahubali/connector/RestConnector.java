package com.jio.bahubali.connector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class RestConnector extends AbstractConnector {

  @Autowired RestTemplate restTemplate;

  public <T, E> ResponseEntity<T> postMapping(String url, E body, Class<T> type) {
    log.info("request has been triggered to :- {} ", url);
    return restTemplate.exchange(url, HttpMethod.POST, getEntity(body), type);
  }

  public <T> ResponseEntity<T> getMapping(String url, HttpEntity entity, Class<T> type) {
    return restTemplate.exchange(url, HttpMethod.GET, entity, type);
  }
}
