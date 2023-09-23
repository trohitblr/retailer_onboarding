package com.jio.bahubali.cache.repository.impl;

import com.jio.bahubali.cache.repository.ReactiveRedisRepository;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ReactiveRedisImpl<T> implements ReactiveRedisRepository<T> {

  @Autowired private final ReactiveRedisTemplate<String, Object> reactiveRedisTemplate;

  public ReactiveRedisImpl(ReactiveRedisTemplate<String, Object> reactiveRedisTemplate) {
    this.reactiveRedisTemplate = reactiveRedisTemplate;
  }

  public Mono<Boolean> hashPut(String key, String fieldKey, T value) {
    return reactiveRedisTemplate.opsForHash().put(key, fieldKey, value);
  }

  public Mono<Object> hashGet(String key, String fieldKey) {
    return reactiveRedisTemplate.opsForHash().get(key, fieldKey);
  }

  public Flux<Object> hashGetAll(String key) {
    return reactiveRedisTemplate.opsForHash().values(key);
  }

  public Mono<Long> hashDelete(String key, String fieldKey) {
    return reactiveRedisTemplate.opsForHash().remove(key, fieldKey);
  }

  public Mono<Object> get(String key) {
    return reactiveRedisTemplate.opsForValue().get(key);
  }

  /**
   * @param key
   * @param value
   * @param expireDuration in mins
   * @return
   */
  public Mono<Boolean> set(String key, T value, long expireDuration) {
    return reactiveRedisTemplate
        .opsForValue()
        .set(key, value)
        .flatMap(
            isSave -> reactiveRedisTemplate.expire(key, Duration.ofSeconds(expireDuration * 60)));
  }

  /**
   * @param key
   * @param value
   * @return Boolean
   */
  public Mono<Boolean> set(String key, T value) {
    return reactiveRedisTemplate.opsForValue().set(key, value);
  }
}
