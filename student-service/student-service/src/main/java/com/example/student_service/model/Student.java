package com.example.student_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Data               // Lombok génère automatiquement getters, setters, toString
@Entity             // Dit à JPA : cette classe = une table en base de données
@Table(name = "students")  // Nom de la table dans MySQL
public class Student {

    @Id                                          // Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    private String nom;
    private String prenom;
    private String email;
}