package com.perficient.consultorio.WebConfig;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

  @Bean
  public DataSource dataSourceGestionCasos() {

    final DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
    // Establece los parametros
    dataSourceBuilder.driverClassName("org.postgresql.Driver");
    dataSourceBuilder.username("consultorio");
    dataSourceBuilder.password("password");
    dataSourceBuilder.url(String.format("jdbc:postgresql://%s:%s/%s", "127.0.0.1", 5432, "consultorio"));
    return dataSourceBuilder.build();
  }

}
