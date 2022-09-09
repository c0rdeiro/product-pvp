package com.theloop.challenge.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToOne()
    private Brand brand;

    public Product(Integer id, Brand brand, String name) {
        this.id = id;
        this.brand = brand;
        this.name = name;
    }

    public Product() {
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
