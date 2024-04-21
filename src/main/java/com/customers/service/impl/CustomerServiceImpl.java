package com.customers.service.impl;

import com.customers.entity.Customer;
import com.customers.repository.CustomerRepository;
import com.customers.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer;
        } else {
            // Handle the case where the customer is not found
            // You can throw an exception or return a default value
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> searchCustomer(String name, String lname) {
        return customerRepository.findByCnameAndLname(name, lname);
    }


    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

//    @Override
//    public Customer update(Customer customer) {
//        Customer customer1=customerRepository.findById(customer.getId()).get();
//        customer1.setN(customer.getName());
//        customer1.setAddress(customer.getAddress());
//        customer1.setPhone(customer.getPhone());
//        return customerRepository.save(customer1);
//
//
//    }


}
