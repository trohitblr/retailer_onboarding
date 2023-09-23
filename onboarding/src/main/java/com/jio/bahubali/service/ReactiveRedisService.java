package com.jio.bahubali.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReactiveRedisService {
  private final RedisTemplate<String, Object> redisTemplate;

  public ReactiveRedisService(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public Object getValue(String key) {
    return redisTemplate.opsForValue().get(key);
  }
}
