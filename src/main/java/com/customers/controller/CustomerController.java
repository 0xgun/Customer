package com.customers.controller;

import com.customers.entity.Customer;
import com.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }
    @GetMapping("")
    public List<Customer> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK).getBody();
    }
    @GetMapping("{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.OK).getBody();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("User Deleted",HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Customer>> searchCustomer(@RequestParam String cname, @RequestParam String lname){
        List<Customer> customers = customerService.searchCustomer(cname, lname);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Customer>> searchCustomer1(@PathVariable String name,@PathVariable String lname){
        List<Customer> customers=customerService.searchCustomer(name, lname);
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
//    @PutMapping("{id}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id ,@RequestBody Customer customer){
//    }
}
