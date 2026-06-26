package com.example.course_service.model;
import lombok.Data;

// Pas de @Entity ici ! Ce n'est pas une table.
// C'est juste un objet pour lire la réponse JSON de Student Service.
@Data
public class Student {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
}