package com.perficient.consultorio.WebConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("Consultorio API")
                        .version("0.1")
                        .description("Proyecto Consultorio Spring Boot 3, Java 17")
        );
    }
}
