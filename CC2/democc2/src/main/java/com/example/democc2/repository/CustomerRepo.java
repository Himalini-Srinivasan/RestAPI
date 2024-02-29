package com.example.democc2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.democc2.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{
    Page<Customer> findAll(Pageable pageable);
}
