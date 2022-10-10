package com.springdemo.mvc.dao;

import java.util.List;

import com.springdemo.mvc.entity.Customer;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);
}
