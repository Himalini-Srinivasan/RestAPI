package com.example.democc2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.democc2.model.ServiceBooking;
import com.example.democc2.service.ServiceBookingService;

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
public class ServiceBookingController {
    @Autowired
    ServiceBookingService serviceBookingService;

    @GetMapping("/bookings")
    public List<ServiceBooking> getAllBookings() {
        return serviceBookingService.getAllBookings();
    }
    @GetMapping("/booking")
    public List<ServiceBooking> getAllBooking(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "bookingId") String sortBy) {
        return serviceBookingService.getAllBooking(page,size,sortBy);
    }

    @GetMapping("/booking/{bookingId}")
    public Optional<ServiceBooking> getBookingById(@PathVariable Long bookingId) {
        return serviceBookingService.getBookingById(bookingId);
    }
    @PostMapping("/booking")
    public ServiceBooking bookService(@RequestBody ServiceBooking serviceBooking) {
        return serviceBookingService.bookService(serviceBooking);
    }


    @PutMapping("/booking/{bookingId}")
    public ServiceBooking updateBooking(@PathVariable Long bookingId, @RequestBody ServiceBooking updatedBooking) {
        Optional<ServiceBooking> existingBookingOptional = serviceBookingService.getBookingById(bookingId);

        if (existingBookingOptional.isPresent()) {
            ServiceBooking existingBooking = existingBookingOptional.get();
            existingBooking.setVehicleType(updatedBooking.getVehicleType());
            existingBooking.setServiceType(updatedBooking.getServiceType());
            existingBooking.setBookingDate(updatedBooking.getBookingDate());
            existingBooking.setTotalCost(updatedBooking.getTotalCost());

            return serviceBookingService.bookService(existingBooking);
        } else {
            throw new RuntimeException("Booking not found with id: " + bookingId);
        }
    }

    @DeleteMapping("/booking/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId) {
        Optional<ServiceBooking> existingBookingOptional = serviceBookingService.getBookingById(bookingId);

        if (existingBookingOptional.isPresent()) {
            serviceBookingService.deleteBookingById(bookingId);
            return ResponseEntity.ok("Booking with ID " + bookingId + " deleted successfully");
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }

}
