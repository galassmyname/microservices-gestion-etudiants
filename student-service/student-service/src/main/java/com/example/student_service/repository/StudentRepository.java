package com.example.student_service.repository;

import com.example.student_service.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Student, Long> → gère la table Student dont la clé est un Long
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Spring génère automatiquement :
    // findAll(), findById(), save(), deleteById()...
    // Tu n'écris rien de plus !
}