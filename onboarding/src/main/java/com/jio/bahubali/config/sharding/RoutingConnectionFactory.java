package com.jio.bahubali.config.sharding;

import io.r2dbc.spi.ConnectionFactory;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.r2dbc.connection.lookup.AbstractRoutingConnectionFactory;
import reactor.core.publisher.Mono;

public class RoutingConnectionFactory extends AbstractRoutingConnectionFactory {

  private final Map<String, ConnectionFactory> targetConnectionFactories;

  public RoutingConnectionFactory(Map<String, ConnectionFactory> targetConnectionFactories) {
    this.targetConnectionFactories = targetConnectionFactories;
  }

  @Override
  protected Mono<Object> determineCurrentLookupKey() {
    return Mono.just(RoutingContextHolder.getRoutingKey());
  }

  @Override
  protected Mono<ConnectionFactory> determineTargetConnectionFactory() {
    // Object lookupKey = determineCurrentLookupKey().block();

    AtomicReference<Object> lookupKeyHolder = new AtomicReference<>(null);

    Mono<Object> lookupKeyMono = determineCurrentLookupKey();

    lookupKeyMono.subscribe(
        lookupKey -> {
          lookupKeyHolder.set(lookupKey);
        });

    Object lookupKey = lookupKeyHolder.get();

    if (lookupKey == null) {
      throw new IllegalStateException(
          "Cannot determine target ConnectionFactory for lookup key [" + lookupKey + "]");
    }
    ConnectionFactory targetConnectionFactory = targetConnectionFactories.get(lookupKey);
    if (targetConnectionFactory == null) {
      throw new IllegalStateException(
          "No target ConnectionFactory found for lookup key [" + lookupKey + "]");
    }
    return Mono.just(targetConnectionFactory);
  }
}
