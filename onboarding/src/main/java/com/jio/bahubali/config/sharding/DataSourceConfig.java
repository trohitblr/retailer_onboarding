package com.jio.bahubali.config.sharding;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

  /* @Bean(name = "db1ConnectionFactory")
     public ConnectionFactory db1ConnectionFactory() {
          // Define the configuration properties for your first database
          ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
                  .option(DRIVER, "your-db-driver-class-name")
                  .option(HOST, "your-db-hostname")
                  .option(PORT, )
                  .option(USER, "your-db-username")
                  .option(PASSWORD, "your-db-password")
                  .option(DATABASE, "your-db-name")
                  .build();

          // Create and return the connection factory for your first database
          return ConnectionFactories.get(options);
      }

      @Bean(name = "db2ConnectionFactory")
      public ConnectionFactory db2ConnectionFactory() {
          // Define the configuration properties for your second database
          ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
                  .option(DRIVER, "your-db-driver-class-name")
                  .option(HOST, "your-db-hostname")
                  .option(PORT, )
                  .option(USER, "your-db-username")
                  .option(PASSWORD, "your-db-password")
                  .option(DATABASE, "your-db-name")
                  .build();

          // Create and return the connection factory for your second database
          return ConnectionFactories.get(options);
      }
  */
}
