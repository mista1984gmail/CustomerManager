package com.mista.soft.dao;

import com.mista.soft.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getAllCustomers();
    public void saveCustomer(Customer customer);
    public Customer getCustomer(long id);
    public void deleteCustomer(long id);
    public List<Customer> search(String keyword);
}
