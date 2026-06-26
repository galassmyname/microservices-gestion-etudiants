package com.example.course_service.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // On stocke seulement l'ID de l'étudiant en base
    // On n'a PAS de @ManyToOne vers Student car il est dans un autre service !
    private Long studentId;
    private Long teacherId;
}