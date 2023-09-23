package com.jio.bahubali.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HttpService {

  private final WebClient webClient;

  public HttpService(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.build();
  }

  public <T> Mono<T> get(String url, Class<T> responseType) {
    return webClient.get().uri(url).retrieve().bodyToMono(responseType);
  }

  public <T> Mono<T> put(String url, Object body, Class<T> responseType) {
    return webClient
        .put()
        .uri(url)
        .body(BodyInserters.fromValue(body))
        .retrieve()
        .bodyToMono(responseType);
  }

  public <T> Mono<T> update(String url, Object body, Class<T> responseType) {
    return webClient
        .method(HttpMethod.PATCH)
        .uri(url)
        .header(HttpHeaders.CONTENT_TYPE, "application/json")
        .body(BodyInserters.fromValue(body))
        .retrieve()
        .bodyToMono(responseType);
  }
}
