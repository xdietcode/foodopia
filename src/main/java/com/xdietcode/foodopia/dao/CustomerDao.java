package com.xdietcode.foodopia.dao;

import com.xdietcode.foodopia.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository // same as @Component, meant for db access
public class CustomerDao {

    public void signUp(Customer customer) {

    }

    public Customer getCustomer(String email) {
        return null;
    }


}
