package com.xdietcode.foodopia.service;

import com.xdietcode.foodopia.dao.MenuInfoDao;
import com.xdietcode.foodopia.entity.MenuItem;
import com.xdietcode.foodopia.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {

    @Autowired
    private MenuInfoDao menuInfoDao;

    /**
     * @return list of restaurants
     */
    public List<Restaurant> getRestaurants() {
        return menuInfoDao.getRestaurant();
    }

    /**
     * @param restaurantId
     * @return list of menuItems
     */
    public List<MenuItem> getAllMenuItem(int restaurantId) {
        return menuInfoDao.getAllMenuItem(restaurantId);
    }

    /**
     * @param menuItemId
     * @return a menuItem
     */
    public MenuItem getMenuItem(int menuItemId) {
        return menuInfoDao.getMenuItem(menuItemId);
    }
}
