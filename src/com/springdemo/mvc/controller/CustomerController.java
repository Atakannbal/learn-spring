package com.springdemo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.mvc.dao.CustomerDAO;
import com.springdemo.mvc.entity.Customer;
import com.springdemo.mvc.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    // inject the customer dao
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        // get the customers from the dao
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

}
