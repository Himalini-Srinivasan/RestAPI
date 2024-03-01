package com.example.cw1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cw1.model.Employee;
import com.example.cw1.repository.EmployeeRepo;
@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepo employeeRepo;
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepo.findById(id).orElse(null);
    }

    public boolean addEmployee(Employee employee) {
        try {
            employeeRepo.save(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
