package com.customers.service;

import com.customers.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
     Customer createCustomer(Customer customer);
     Optional<Customer> getCustomerById(Long id);
    List<Customer> getAllCustomer();
     List<Customer> searchCustomer(String name, String lname);
    void deleteCustomer(Long id);
//    Customer update(Customer customer);

}
