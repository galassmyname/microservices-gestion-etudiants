package com.example.student_service.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI studentServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student Service API")
                        // Description claire pour le jury
                        .description("Microservice de gestion des étudiants — Architecture SOA")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Neyma")
                                .email("neyma@uadb.edu.sn")
                        )
                );
    }
}
