package com.springdemo.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.mvc.dao.CustomerDAO;
import com.springdemo.mvc.entity.Customer;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    // need to inject customer dao
    final CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers(int theSortField) {
        // TODO Auto-generated method stub
        return customerDAO.getCustomers(theSortField);
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
       customerDAO.deleteCustomer(theId);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomer(String theSearchName) {
        return customerDAO.searchCustomer(theSearchName);
    }
    
}
    
