package com.example.democc2.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long customerId;
    String customerName;
    String customerPhoneNo;
    String customerAddress;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    List<ServiceBooking> serviceBooking=new ArrayList<>();
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerPhoneNo() {
        return customerPhoneNo;
    }
    public void setCustomerPhoneNo(String customerPhoneNo) {
        this.customerPhoneNo = customerPhoneNo;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public List<ServiceBooking> getServiceBooking() {
        return serviceBooking;
    }
    public void setServiceBooking(List<ServiceBooking> serviceBooking) {
        this.serviceBooking = serviceBooking;
    }
    
}
