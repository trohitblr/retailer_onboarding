package com.jio.bahubali.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
@io.swagger.v3.oas.annotations.security.SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer")
public class SwaggerConfig {
  @Bean
  public OpenAPI baseOpenApi() {
    return new OpenAPI()
        .info(
            new Info().title("OMS-create-order").version("1.0.0").description("OMS-create-order"));
  }
}
