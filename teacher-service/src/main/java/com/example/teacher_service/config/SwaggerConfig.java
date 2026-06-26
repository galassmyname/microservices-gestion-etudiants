package com.example.teacher_service.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI teacherServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Teacher Service API")
                        .description("Microservice de gestion des professeurs")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Neyma")
                                .email("neyma@uadb.edu.sn")
                        )
                );
    }
}