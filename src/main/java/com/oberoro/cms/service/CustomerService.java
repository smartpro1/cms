package com.oberoro.cms.service;

import com.oberoro.cms.dao.CustomerDAO;
import com.oberoro.cms.exception.CustomerNotFoundException;
import com.oberoro.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;


    public Customer addCustomer(Customer customer){
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers(){

        return customerDAO.findAll();
    }

    public Optional<Customer> getCustomerById(int customerId){
        Optional<Customer> customer = customerDAO.findById(customerId);
        if(!customer.isPresent())
            throw new CustomerNotFoundException("this customer with id '" + customerId + "' does not exist");
        return customer;
    }

    public Customer updateCustomer(int customerId, Customer customer){

        customer.setCustomerId(customerId);
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId){

        customerDAO.deleteById(customerId);

    }

}
