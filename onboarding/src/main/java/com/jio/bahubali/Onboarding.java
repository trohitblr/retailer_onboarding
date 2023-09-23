package com.jio.bahubali;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

// x@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableR2dbcAuditing
// @ComponentScan("com.jio.bahubali.*")
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.fynd.**", "com.gofynd", "com.sdk.**", "com.jio.bahubali.*"})
// @EnableJpaAuditing
@SpringBootApplication
public class Onboarding {
  public static void main(String[] args) {
    SpringApplication.run(Onboarding.class, args);
  }

  @Bean
  ConnectionFactoryInitializer initializer(
      @Qualifier("connectionFactory") ConnectionFactory connectionFactory) {
    ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();

    /*connectionFactory =
    ConnectionFactories.get("r2dbc:postgresql://postgres:postgres@localhost:5432/falcon_rcpl");*/
    initializer.setConnectionFactory(connectionFactory);
    ResourceDatabasePopulator resource =
        new ResourceDatabasePopulator(new ClassPathResource("schema.sql"));
    initializer.setDatabasePopulator(resource);
    return initializer;
  }

  /* private static final String REDIS_KEY = "ext_sample";

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired ExtensionProperties extensionProperties;

  @Autowired
  @Qualifier("redis-pool")
  JedisPool jedis;

  ExtensionCallback callbacks =
      new ExtensionCallback(
          (fdkSession) -> {
            logger.info("In auth callback");
            return extensionProperties.getBaseUrl() + "/company/" + "61";
          },
          (context) -> {
            logger.info("In install callback");
            return extensionProperties.getBaseUrl();
          },
          (fdkSession) -> {
            logger.info("In uninstall callback");
            return extensionProperties.getBaseUrl();
          },
          (fdkSession) -> {
            logger.info("In auto-install callback");
            return extensionProperties.getBaseUrl();
          });

  @Bean
  @DependsOn({"redis-pool"})
  public com.fynd.extension.model.Extension getExtension() {
    Extension extension = new Extension();
    return extension.initialize(extensionProperties, new RedisStorage(jedis, REDIS_KEY), callbacks);
  }*/
}
