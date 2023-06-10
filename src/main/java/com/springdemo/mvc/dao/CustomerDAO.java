package com.springdemo.mvc.dao;

import java.util.List;

import com.springdemo.mvc.entity.Customer;

public interface CustomerDAO {
    public List<Customer> getCustomers(int theSortField);

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public Object deleteCustomer(int theId);

    public List<Customer> searchCustomer(String theSearchName);
}
