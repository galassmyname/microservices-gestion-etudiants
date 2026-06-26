package com.example.course_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI courseServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Course Service API")
                        .description("Microservice de gestion des cours — communique avec Student et Teacher Service")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Neyma")
                                .email("neyma@uadb.edu.sn")
                        )
                );
    }
}