package com.app.pocredis.controller;

import com.app.pocredis.dto.Student;
import com.app.pocredis.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class StudentController {
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public Map<String, Student > findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student findById(@PathVariable String id) {
        return studentRepository.findById(id);
    }

    @PostMapping("/students")
    public void createStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentRepository.delete(id);
    }
}
