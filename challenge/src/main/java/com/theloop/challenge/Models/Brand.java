package com.theloop.challenge.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Brand {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public Brand(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand() {
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
}
