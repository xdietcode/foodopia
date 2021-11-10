package com.xdietcode.foodopia.service;

import com.xdietcode.foodopia.dao.CustomerDao;
import com.xdietcode.foodopia.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired // inject CustomerDao into Customer Service
    private CustomerDao customerDao;

    public void signUp(Customer customer) {
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }

}
