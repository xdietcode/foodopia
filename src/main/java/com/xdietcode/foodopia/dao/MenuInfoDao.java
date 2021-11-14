package com.xdietcode.foodopia.dao;

import com.xdietcode.foodopia.entity.MenuItem;
import com.xdietcode.foodopia.entity.Restaurant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class MenuInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @return list of restaurants
     */
    public List<Restaurant> getRestaurants() {

        Session session = sessionFactory.openSession();
        try {
            return session.createCriteria(Restaurant.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) // remove duplicates
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @param restaurantId
     * @return list of MenuItems of a given restaurant
     */
    public List<MenuItem> getAllMenuItem(int restaurantId) {
        Session session = sessionFactory.openSession();
        try {
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
            // because Restaurant fetchType=Eager, menuItems are loaded
            if (restaurant != null) return restaurant.getMenuItemList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @param menuItemId
     * @return return a MenuItem
     */
    public MenuItem getMenuItems(int menuItemId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return session.get(MenuItem.class, menuItemId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return null;
    }

}
