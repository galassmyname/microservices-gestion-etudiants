package com.example.course_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CourseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseServiceApplication.class, args);
	}
    // On déclare RestTemplate comme un Bean Spring
    // Comme ça on peut l'injecter partout avec @Autowired ou @RequiredArgsConstructor
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
