package com.example.democc2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.democc2.model.Customer;
import com.example.democc2.repository.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @SuppressWarnings("null")
    public Customer bookCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    public List<Customer> getAllCustomer(int page,int size,String sortBy) {
        Pageable pageable=PageRequest.of(page,size,Sort.by(sortBy));
        Page<Customer> pageResult=customerRepo.findAll(pageable);
        return pageResult.getContent();
    }

    @SuppressWarnings("null")
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepo.findById(id);
    }
    @SuppressWarnings("null")
    public void deleteCustomerById(Long id) {
        customerRepo.deleteById(id);
    }
}
