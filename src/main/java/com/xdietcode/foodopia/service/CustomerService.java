package com.xdietcode.foodopia.service;

import com.xdietcode.foodopia.dao.CustomerDao;
import com.xdietcode.foodopia.entity.Cart;
import com.xdietcode.foodopia.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired // inject CustomerDao into Customer Service
    private CustomerDao customerDao;

    /**
     * @param customer
     */
    public void signUp(Customer customer) {
        // for each customer, create a cart
        Cart cart = new Cart();
        customer.setCart(cart);
        customer.setEnabled(true);

        customerDao.signUp(customer);
    }

    /**
     * @param email
     * @return customer
     */
    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }

}
