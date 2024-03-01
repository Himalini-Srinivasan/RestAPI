package com.example.classwork.controller;



import org.springframework.web.bind.annotation.RestController;

import com.example.classwork.model.Student;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StudentController {
    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(1L, "John Doe", "This is a student description.");
        return student;
    }
}