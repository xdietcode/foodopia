package com.xdietcode.foodopia.dao;

import com.xdietcode.foodopia.entity.Cart;
import com.xdietcode.foodopia.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Remove an item from cart
     *
     * @param cartItemId
     */
    public void removeItem(int cartItemId) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            OrderItem cartItem = session.get(OrderItem.class, cartItemId);
            Cart cart = cartItem.getCart();
            cart.getOrderItemList().remove(cartItem);

            session.beginTransaction();
            session.delete(cartItem);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Empty cart
     *
     * @param cart
     */
    public void removeAll(Cart cart) {

        for (OrderItem item : cart.getOrderItemList()) {
            this.removeItem(item.getId());
        }
    }

}
