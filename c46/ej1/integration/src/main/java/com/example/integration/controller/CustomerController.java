package com.example.integration.controller;

import com.example.integration.model.Customer;
import com.example.integration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("customers")
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
        Optional<Customer> customer = customerService.findById(id);
        if(!customer.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(customer, HttpStatus.OK);
    }
}
