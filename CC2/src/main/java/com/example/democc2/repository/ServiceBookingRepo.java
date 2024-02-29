package com.example.democc2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.democc2.model.ServiceBooking;

@Repository
public interface ServiceBookingRepo extends JpaRepository<ServiceBooking, Long> {
    Page<ServiceBooking> findAll(Pageable pageable);
}