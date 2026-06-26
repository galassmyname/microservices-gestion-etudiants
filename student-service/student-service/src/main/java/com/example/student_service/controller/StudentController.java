package com.example.student_service.controller;


import com.example.student_service.model.Student;
import com.example.student_service.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Tag(name = "Étudiants", description = "Opérations de gestion des étudiants")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    @Operation(
            summary = "Liste tous les étudiants",
            description = "Retourne la liste complète des étudiants enregistrés en base"
    )
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un étudiant par ID")
    @ApiResponse(responseCode = "200", description = "Étudiant trouvé")
    @ApiResponse(responseCode = "404", description = "Étudiant non trouvé")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Ajouter un étudiant",
            description = "Crée un nouvel étudiant et le sauvegarde en base de données"
    )
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un étudiant")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un étudiant")
    @ApiResponse(responseCode = "204", description = "Supprimé avec succès")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}