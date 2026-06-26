# Microservices — Gestion Étudiants, Cours & Professeurs

Application complète basée sur une architecture microservices.

## Stack technique
- Java 17 · Spring Boot · Spring Cloud Gateway
- Angular 21
- MySQL 8
- Docker & Docker Compose
- Swagger / OpenAPI 3.0

## Services
| Service | Port | Description |
|---|---|---|
| API Gateway | 8080 | Point d'entrée unique |
| Student Service | 8081 | Gestion des étudiants |
| Course Service | 8082 | Gestion des cours |
| Teacher Service | 8083 | Gestion des professeurs |
| Frontend Angular | 4200 | Interface utilisateur |

## Lancer le projet

### Avec Docker
```bash
docker-compose up --build
```

### Sans Docker
Lance chaque service dans un terminal séparé :
```bash
cd student-service && mvn spring-boot:run
cd course-service  && mvn spring-boot:run
cd teacher-service && mvn spring-boot:run
cd api-gateway     && mvn spring-boot:run
cd frontend-microservices && ng serve
```

## Documentation APIs
- Student Service : http://localhost:8081/swagger-ui.html
- Course Service  : http://localhost:8082/swagger-ui.html
- Teacher Service : http://localhost:8083/swagger-ui.html
