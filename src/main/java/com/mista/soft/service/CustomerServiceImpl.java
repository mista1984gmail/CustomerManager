package com.mista.soft.service;

import com.mista.soft.dao.CustomerDAO;
import com.mista.soft.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDAO customerDAO;
    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(long id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(long id) {
        customerDAO.deleteCustomer(id);
    }

    @Override
    @Transactional
    public List<Customer> search(String keyword) {
        return customerDAO.search(keyword);
    }

}
