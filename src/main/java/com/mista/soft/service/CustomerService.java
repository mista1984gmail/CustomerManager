package com.mista.soft.service;

import com.mista.soft.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    public List<Customer> getAllCustomers();
    public void saveCustomer(Customer customer);
    public Customer getCustomer(long id);
    public void deleteCustomer(long id);
    public List<Customer> search(String keyword);

}
