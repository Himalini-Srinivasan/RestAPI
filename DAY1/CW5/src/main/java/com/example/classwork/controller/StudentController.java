package com.example.classwork.controller;



import org.springframework.web.bind.annotation.RestController;

import com.example.classwork.model.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class StudentController {
    @GetMapping("/student")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Welcome, John!"));
        students.add(new Student("Alice", "Hello, Alice!"));
        students.add(new Student("Bob", "Greetings, Bob!"));

        return students;
    }
}