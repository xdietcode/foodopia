package com.xdietcode.foodopia.service;

import com.xdietcode.foodopia.dao.OrderItemDao;
import com.xdietcode.foodopia.entity.Customer;
import com.xdietcode.foodopia.entity.MenuItem;
import com.xdietcode.foodopia.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private MenuInfoService menuInfoService;

    @Autowired
    private CustomerService customerService;

    /**
     * saves an orderItem to cart
     *
     * @param menuId
     */
    public void saveItem(int menuId) {

        OrderItem orderItem = new OrderItem();
        MenuItem menuItem = menuInfoService.getMenuItem(menuId);

        // retrieve current user info
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Customer customer = customerService.getCustomer(username);

        orderItem.setMenuItem(menuItem);
        orderItem.setCart(customer.getCart());
        orderItem.setQuantity(1); // TODO: allows front-end to send different quantity
        orderItem.setPrice(menuItem.getPrice());
        orderItemDao.save(orderItem);

    }


}
