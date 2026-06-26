package com.example.course_service.model;

import lombok.Data;

// Pas de @Entity — juste pour lire la réponse JSON de Teacher Service
@Data
public class Teacher {
    private Long id;
    private String nom;
    private String prenom;
    private String matiere;
    private String email;
}
