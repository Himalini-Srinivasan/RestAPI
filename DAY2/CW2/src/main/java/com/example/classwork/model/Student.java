package com.example.classwork.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
     @JsonProperty("name")
    private String studentName;

    @JsonProperty("age")
    private int studentAge;
    public Student() {
    }

    public Student(String studentName, int studentAge) {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }
}
