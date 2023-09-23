package com.jio.bahubali.config.sharding;

import com.jio.bahubali.enums.DBTypeEnum;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.r2dbc.core.DatabaseClient;

// @Configuration
// @EnableR2dbcRepositories(basePackages = {"com.jio.bahubali.model",
// "com.jio.bahubali.repository"})
public class ShardConfiguration {

  @Autowired private Environment env;

  // @Value("${spring.r2dbc.conn.shard1}")
  // private String shard1Config;

  // @Value("${spring.r2dbc.conn.shard2}")
  // private String shard2Config;

  // @Bean
  // @ConfigurationProperties(prefix = "spring.r2dbc.shard1")
  public ConnectionFactoryOptions shard1ConnectionFactoryOptions() {

    // String url =
    // "r2dbc:postgresql://fynd_falcon_asp_readwrite:readWrite_falcon_asp!2023@172.16.0.28:5432/falcon_asp";
    // ConnectionFactoryOptions options = ConnectionFactoryOptions.parse(url);

    System.out.println("connection url");
    /*
               return ConnectionFactoryOptions.builder()
                        .option(ConnectionFactoryOptions.DRIVER, "postgresql")
                        .option(ConnectionFactoryOptions.HOST, "10.166.181.231")
                        .option(ConnectionFactoryOptions.PORT, 5432)
                        .option(ConnectionFactoryOptions.USER, "root")
                        .option(ConnectionFactoryOptions.PASSWORD, "root")
                        .option(ConnectionFactoryOptions.DATABASE, "oms_asp")
                        .build();
    */

    return ConnectionFactoryOptions.builder()
        .option(ConnectionFactoryOptions.DRIVER, "postgresql")
        .option(ConnectionFactoryOptions.HOST, "172.16.0.28")
        .option(ConnectionFactoryOptions.PORT, 5432)
        .option(ConnectionFactoryOptions.USER, "fynd_falcon_asp_readwrite")
        .option(ConnectionFactoryOptions.PASSWORD, "readWrite_falcon_asp!2023")
        .option(ConnectionFactoryOptions.DATABASE, "falcon_asp")
        .build();

    /*
    ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
            .option(ConnectionFactoryOptions.DRIVER, "postgresql")
            .option(ConnectionFactoryOptions.URI, "postgresql://fynd_falcon_b2b_readwrite:readWrite_falcon_b2b!2023@172.16.0.28:5432/falcon_b2b")
            .build();*/

    // return ConnectionFactoryOptions.parse(shard1Config);

    // return
    // ConnectionFactoryOptions.parse("r2dbc:postgresql://fynd_falcon_asp_readwrite:readWrite_falcon_asp!2023@172.16.0.28:5432/falcon_asp");
  }

  // @Bean
  public ConnectionFactory shard1ConnectionFactory() {
    ConnectionFactoryOptions shard1ConnectionFactoryOptions = shard1ConnectionFactoryOptions();
    // return
    // ConnectionFactories.get("r2dbc:postgresql://fynd_falcon_asp_readwrite:readWrite_falcon_asp!2023@172.16.0.28:5432/falcon_asp");
    return ConnectionFactories.get(shard1ConnectionFactoryOptions);
  }

  // @Bean
  // @ConfigurationProperties(prefix = "spring.r2dbc.shard2")
  public ConnectionFactoryOptions shard2ConnectionFactoryOptions() {

    // String url =
    // "r2dbc:postgresql://fynd_falcon_pbg_readwrite:readWrite_falcon_pbg!2023@172.16.0.28:5432/falcon_pbg";
    // ConnectionFactoryOptions options = ConnectionFactoryOptions.parse(url);

    // ConnectionFactories.get("r2dbc:postgresql://fynd_falcon_pbg_readwrite:readWrite_falcon_pbg!2023@172.16.0.28:5432/falcon_pbg");

    System.out.println("connection url 2");
    // return ConnectionFactoryOptions.parse(shard2Config);

    /*
       return ConnectionFactoryOptions.builder()
               .option(ConnectionFactoryOptions.DRIVER, "postgresql")
               .option(ConnectionFactoryOptions.HOST, "10.166.181.231")
               .option(ConnectionFactoryOptions.PORT, 5432)
               .option(ConnectionFactoryOptions.USER, "root")
               .option(ConnectionFactoryOptions.PASSWORD, "root")
               .option(ConnectionFactoryOptions.DATABASE, "oms_b2b")
               .build();

    */

    return ConnectionFactoryOptions.builder()
        .option(ConnectionFactoryOptions.DRIVER, "postgresql")
        .option(ConnectionFactoryOptions.HOST, "172.16.0.28")
        .option(ConnectionFactoryOptions.PORT, 5432)
        .option(ConnectionFactoryOptions.USER, "fynd_falcon_pbg_readwrite")
        .option(ConnectionFactoryOptions.PASSWORD, "readWrite_falcon_pbg!202")
        .option(ConnectionFactoryOptions.DATABASE, "falcon_pbg")
        .build();
  }

  // @Bean
  public ConnectionFactory shard2ConnectionFactory() {
    ConnectionFactoryOptions shard2ConnectionFactoryOptions = shard2ConnectionFactoryOptions();
    // return
    // ConnectionFactories.get("r2dbc:postgresql://fynd_falcon_pbg_readwrite:readWrite_falcon_pbg!2023@172.16.0.28:5432/falcon_pbg");

    return ConnectionFactories.get(shard2ConnectionFactoryOptions);
  }

  // @Bean(name = "multiRoutingConnectionFactory")
  public RoutingConnectionFactory multiRoutingConnectionFactory() {
    Map<String, ConnectionFactory> factoriesMap = new HashMap<>();
    factoriesMap.put(DBTypeEnum.SHARD1.name(), shard1ConnectionFactory());
    factoriesMap.put(DBTypeEnum.SHARD2.name(), shard2ConnectionFactory());
    return multiRoutingConnectionFactoryInitiate(factoriesMap, shard1ConnectionFactory());
  }

  public RoutingConnectionFactory multiRoutingConnectionFactoryInitiate(
      Map<String, ConnectionFactory> targetConnectionFactories,
      ConnectionFactory defaultTargetConnectionFactory) {
    RoutingConnectionFactory multiRoutingConnectionFactory =
        new RoutingConnectionFactory(targetConnectionFactories);
    multiRoutingConnectionFactory.setTargetConnectionFactories(targetConnectionFactories);
    multiRoutingConnectionFactory.setDefaultTargetConnectionFactory(defaultTargetConnectionFactory);
    return multiRoutingConnectionFactory;
  }

  // @Bean
  public DatabaseClient databaseClient() {
    return DatabaseClient.create(multiRoutingConnectionFactory());
  }
}
