package com.example.cw1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long JobId;
    String JobTitle;
    int minSalary;
    String JobDescription;
    int maxSalary;
    public Long getJobId() {
        return JobId;
    }
    public void setJobId(Long jobId) {
        JobId = jobId;
    }
    public String getJobTitle() {
        return JobTitle;
    }
    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }
    public int getMinSalary() {
        return minSalary;
    }
    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }
    public String getJobDescription() {
        return JobDescription;
    }
    public void setJobDescription(String jobDescription) {
        JobDescription = jobDescription;
    }
    public int getMaxSalary() {
        return maxSalary;
    }
    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }
    
    
    
    
}
