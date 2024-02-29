package com.example.democc2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.democc2.model.Customer;
import com.example.democc2.service.CustomerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }
    @GetMapping("/customer")
    public List<Customer> getAllCustomer(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "Id") String sortBy) {
        return customerService.getAllCustomer(page,size,sortBy);
    }

    @GetMapping("/customer/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }
    @PostMapping("/customer")
    public Customer bookCustomer(@RequestBody Customer customer) {
        return customerService.bookCustomer(customer);
    }


    @PutMapping("/customer/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
        Optional<Customer> existingCustomerOptional = customerService.getCustomerById(customerId);

        if (existingCustomerOptional.isPresent()) {
            Customer existingCustomer = existingCustomerOptional.get();
            existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
            existingCustomer.setCustomerPhoneNo(updatedCustomer.getCustomerPhoneNo());
            existingCustomer.setCustomerAddress(updatedCustomer.getCustomerAddress());

            return customerService.bookCustomer(existingCustomer);
        } else {
            throw new RuntimeException(" not found with id: " + customerId);
        }
    }

    @DeleteMapping("//{Id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
        Optional<Customer> existingCustomerOptional = customerService.getCustomerById(customerId);

        if (existingCustomerOptional.isPresent()) {
            customerService.deleteCustomerById(customerId);
            return ResponseEntity.ok(" with ID " + customerId + " deleted successfully");
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }

}
