package com.pluralsight.psdemo.config;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class PersistanceConfiguration {
    // Any methods that we define can return bean def that will be stored in Spring context
    @Bean
    public DataSource dataSource() {
        // Spring will look if a datasource object already exists and if so it will replace
        // it with the below Bean
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5432/conference_app");
        return builder.build();
    }
}
