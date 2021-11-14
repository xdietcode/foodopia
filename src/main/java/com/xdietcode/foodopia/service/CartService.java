package com.xdietcode.foodopia.service;

import com.xdietcode.foodopia.entity.Cart;
import com.xdietcode.foodopia.entity.Customer;
import com.xdietcode.foodopia.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CustomerService customerService;

    public Cart getCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Customer customer = customerService.getCustomer(username);

        if (customer != null) {
            Cart cart = customer.getCart();

            double totalPrice = 0;
            for (OrderItem orderItem : cart.getOrderItemList()) {
                totalPrice += orderItem.getPrice() * orderItem.getQuantity();
            }
            cart.setTotalPrice(totalPrice);
            return cart;
        }
        return new Cart();
    }

}
