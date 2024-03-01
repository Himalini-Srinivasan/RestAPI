package com.example.cw1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.cw1.model.Job;
import com.example.cw1.service.JobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class JobController {
    @Autowired
    JobService jobService;

    @PostMapping("/api/job")
    public Job addJob(@RequestBody Job job) {
        
        return jobService.addJob(job); 
    }
    @GetMapping("/api/job")
    public List<Job> getJobs() {
        return jobService.getJobs();
    }
    @GetMapping("/api/job/{jobId}")
    public Job getJobById(@PathVariable Long jobId) {
        return jobService.getJobById(jobId);
    }
    
    
    
}

