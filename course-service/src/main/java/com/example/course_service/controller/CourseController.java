package com.example.course_service.controller;
import com.example.course_service.model.Course;
import com.example.course_service.service.CourseService;
import com.example.course_service.model.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@Tag(name = "Cours", description = "Opérations de gestion des cours")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    @Operation(
            summary = "Liste tous les cours",
            description = "Retourne la liste complète des cours enregistrés en base"
    )
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un cours par ID")
    @ApiResponse(responseCode = "200", description = "Cours trouvé")
    @ApiResponse(responseCode = "404", description = "Cours non trouvé")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/{id}/details")
    @Operation(
            summary = "Détails complets d'un cours",
            description = "Retourne le cours enrichi avec les infos de l'étudiant (Student Service) et du professeur (Teacher Service) — communication inter-microservices via RestTemplate"
    )
    @ApiResponse(responseCode = "200", description = "Cours avec étudiant et professeur")
    @ApiResponse(responseCode = "404", description = "Cours, étudiant ou professeur non trouvé")
    public Map<String, Object> getCourseWithDetails(@PathVariable Long id) {
        return courseService.getCourseWithDetails(id);
    }

    @PostMapping
    @Operation(
            summary = "Ajouter un cours",
            description = "Crée un nouveau cours lié à un étudiant et un professeur via leurs IDs"
    )
    @ApiResponse(responseCode = "200", description = "Cours créé avec succès")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un cours")
    @ApiResponse(responseCode = "204", description = "Supprimé avec succès")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}