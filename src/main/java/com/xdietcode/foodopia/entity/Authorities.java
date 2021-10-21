package com.xdietcode.foodopia.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable{
    private static final long serialVersionUID = 8734140534986494039L;

    @Id
    private String emaill;

    private String authorities;

    public String getEmaill() {
        return emaill;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
