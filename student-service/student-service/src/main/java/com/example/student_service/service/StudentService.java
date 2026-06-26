package com.example.student_service.service;

import com.example.student_service.model.Student;
import com.example.student_service.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service                  // Dit à Spring : cette classe est un service (géré par Spring)
@RequiredArgsConstructor  // Lombok génère le constructeur avec les dépendances
public class StudentService {

    private final StudentRepository studentRepository;
    // Spring injecte automatiquement le repository (injection de dépendances)

    // Récupérer tous les étudiants
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Récupérer un étudiant par son id
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Ajouter un étudiant
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Modifier un étudiant
    public Student updateStudent(Long id, Student newData) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
        existing.setNom(newData.getNom());
        existing.setPrenom(newData.getPrenom());
        existing.setEmail(newData.getEmail());
        return studentRepository.save(existing);
    }

    // Supprimer un étudiant
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}