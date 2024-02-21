package com.example.democc1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.democc1.model.ServiceBooking;

@Repository
public interface ServiceBookingRepo extends JpaRepository<ServiceBooking, Long> {
}