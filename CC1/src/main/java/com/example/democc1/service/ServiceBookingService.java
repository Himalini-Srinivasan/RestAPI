package com.example.democc1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.democc1.model.ServiceBooking;
import com.example.democc1.repository.ServiceBookingRepo;

@Service
public class ServiceBookingService {
    @Autowired
    ServiceBookingRepo serviceBookingRepo;

    public ServiceBooking bookService(ServiceBooking serviceBooking) {
        // Add any business logic or validation here
        return serviceBookingRepo.save(serviceBooking);
    }

    public List<ServiceBooking> getAllBookings() {
        return serviceBookingRepo.findAll();
    }

    public Optional<ServiceBooking> getBookingById(Long id) {
        return serviceBookingRepo.findById(id);
    }
    public void deleteBookingById(Long id) {
        serviceBookingRepo.deleteById(id);
    }
}
