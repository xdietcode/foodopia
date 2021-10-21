package com.xdietcode.foodopia.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    private static final long serialVersionUID = 8436097833452420298L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double totalPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
