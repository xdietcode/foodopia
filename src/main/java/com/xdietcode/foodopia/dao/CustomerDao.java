package com.xdietcode.foodopia.dao;

import com.xdietcode.foodopia.entity.Authorities;
import com.xdietcode.foodopia.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // same as @Component, meant for db access
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void signUp(Customer customer) {

        // Set authorities
        Authorities authorities = new Authorities();
        authorities.setEmaill(customer.getEmail());
        authorities.setAuthorities("ROLE_USER");

        Session session = null;
        try {
            session = sessionFactory.openSession(); // create session
            // atomic operation, rollback when any table fails
            session.beginTransaction();
            session.save(customer);
            session.save(authorities);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }

    }

    public Customer getCustomer(String email) {
        return null;
    }


}
