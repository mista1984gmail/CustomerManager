package com.mista.soft.dao;


import com.mista.soft.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("from Customer "
                , Customer.class);
        List<Customer>allCustomers=query.getResultList();
        //List<Employee>allEmployees = session.createQuery("from Employee"
        //               , Employee.class).getResultList();
        return allCustomers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(long id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,id);
        return customer;
    }

    @Override
    public void deleteCustomer(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("delete from Customer "+
                "where id =:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> search(String keyword) {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("FROM Customer WHERE name = :customerName");
        query.setParameter("customerName", keyword);
        List<Customer>allCustomers=query.getResultList();
        return allCustomers;
    }
}
