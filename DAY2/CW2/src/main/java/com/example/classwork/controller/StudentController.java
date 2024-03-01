package com.example.classwork.controller;



import org.springframework.web.bind.annotation.RestController;

import com.example.classwork.model.Student;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {
   @PostMapping("/students")
    public String createStudent(@RequestBody Student student) {
        return "Student created: " + student.getStudentName() + ", Age: " + student.getStudentAge() + ".";
    }
}