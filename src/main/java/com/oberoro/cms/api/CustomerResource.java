package com.oberoro.cms.api;

import com.oberoro.cms.model.Customer;
import com.oberoro.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerResource {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return customer;
    }

    @GetMapping
    public List<Customer> all(){
       return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable int id){
       Optional<Customer> customer = customerService.getCustomerById(id);
       return customer;
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer){
        return customerService.updateCustomer(customerId, customer);
    }
    @DeleteMapping("/{customerId}")
    public void deleteCustomerById(@PathVariable int customerId){
       customerService.deleteCustomer(customerId);
    }
}
