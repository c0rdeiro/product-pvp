package com.theloop.challenge.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ListPrice {
    @Id
    @GeneratedValue
    private Integer id;

    private double price;

    public ListPrice(Integer id, double price) {
        this.id = id;
        this.price = price;
    }

    public ListPrice() {
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
