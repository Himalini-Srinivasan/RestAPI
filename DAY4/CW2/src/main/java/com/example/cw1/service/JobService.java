package com.example.cw1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cw1.model.Job;
import com.example.cw1.repository.JobRepo;

@Service
public class JobService {
    @Autowired
    JobRepo jobRepo;
    @SuppressWarnings("null")
    public Job addJob(Job job)
    {
        return jobRepo.save(job);
    }
    public List<Job> getJobs()
    {
        return jobRepo.findAll();
    }
    public Job getJobById(Long jobId) {
        return jobRepo.findById(jobId).orElse(null);
    }
    
}
