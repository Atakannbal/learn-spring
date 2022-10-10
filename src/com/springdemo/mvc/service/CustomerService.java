package com.springdemo.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springdemo.mvc.entity.Customer;

@Service
public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);


    
}
