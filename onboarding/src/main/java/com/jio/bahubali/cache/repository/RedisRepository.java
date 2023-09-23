package com.jio.bahubali.cache.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository<T> {

  @Autowired private RedisTemplate redisTemplate;

  public void hashPut(String key, String hashKey, T value) {
    redisTemplate.opsForHash().put(key, hashKey, value);
  }

  public T hashGet(String key, String hashKey) {
    return (T) redisTemplate.opsForHash().get(key, hashKey);
  }

  public List<T> hashGetAll(String key) {
    return (List<T>) redisTemplate.opsForHash().values(key);
  }

  public void hashDelete(String key, String hashKey) {
    redisTemplate.opsForHash().delete(key, hashKey);
  }
}
