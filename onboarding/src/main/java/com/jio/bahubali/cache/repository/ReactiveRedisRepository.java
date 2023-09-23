package com.jio.bahubali.cache.repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveRedisRepository<T> {
  Mono<Boolean> hashPut(String key, String fieldKey, T value);

  Mono<Object> hashGet(String key, String fieldKey);

  Flux<Object> hashGetAll(String key);

  Mono<Long> hashDelete(String key, String fieldKey);

  Mono<Object> get(String key);

  Mono<Boolean> set(String key, T value, long expireDuration);

  Mono<Boolean> set(String key, T value);
}
