
package com.example.democc2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.democc2.model.ServiceBooking;
import com.example.democc2.repository.ServiceBookingRepo;

@Service
public class ServiceBookingService {
    @Autowired
    ServiceBookingRepo serviceBookingRepo;

    @SuppressWarnings("null")
    public ServiceBooking bookService(ServiceBooking serviceBooking) {
        return serviceBookingRepo.save(serviceBooking);
    }

    public List<ServiceBooking> getAllBookings() {
        return serviceBookingRepo.findAll();
    }

    public List<ServiceBooking> getAllBooking(int page,int size,String sortBy) {
        Pageable pageable=PageRequest.of(page,size,Sort.by(sortBy));
        Page<ServiceBooking> pageResult=serviceBookingRepo.findAll(pageable);
        return pageResult.getContent();
    }

    @SuppressWarnings("null")
    public Optional<ServiceBooking> getBookingById(Long id) {
        return serviceBookingRepo.findById(id);
    }
    @SuppressWarnings("null")
    public void deleteBookingById(Long id) {
        serviceBookingRepo.deleteById(id);
    }
}
