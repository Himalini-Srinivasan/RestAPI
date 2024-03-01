package com.example.classwork.controller;



import org.springframework.web.bind.annotation.RestController;

import com.example.classwork.model.Address;


import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AddressController {
    @GetMapping("/address")
     public Address f1()
    {
        Address address = new Address("John Doe", 123, "Main St", 12345, "B K Pudur", "Coimbatore", "Tamil Nadu", "India");
        return address;
    }
}