package com.example.course_service.service;

import com.example.course_service.model.Course;
import com.example.course_service.model.Student;
import com.example.course_service.model.Teacher;
import com.example.course_service.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final RestTemplate restTemplate;
    // RestTemplate = le client HTTP qui appelle Student Service

    // Ajouter un cours
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Lister tous les cours
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    // Dans CourseService.java
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé"));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
    // Récupérer un cours + étudiant + professeur
    public Map<String, Object> getCourseWithDetails(Long courseId) {

        // 1. Chercher le cours dans notre base
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé"));

        // 2. Appeler Student Service (port 8081)
        Student student = restTemplate.getForObject(
                "http://localhost:8081/students/" + course.getStudentId(),
                Student.class
        );

        // 3. Appeler Teacher Service (port 8083)
        Teacher teacher = restTemplate.getForObject(
                "http://localhost:8083/teachers/" + course.getTeacherId(),
                Teacher.class
        );

        // 4. Combiner les trois dans la réponse
        Map<String, Object> result = new HashMap<>();
        result.put("course", course);
        result.put("student", student);
        result.put("teacher", teacher);

        return result;
    }
}
