package com.theloop.challenge.Models;

import com.theloop.challenge.Enums.CurrencyEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class PVP {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Product product;
    @ManyToOne
    private ListPrice price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private CurrencyEnum currency;
    private Integer priority;

    public PVP(Integer id,
               Product product,
               ListPrice price,
               LocalDateTime startDate,
               LocalDateTime endDate,
               CurrencyEnum currency,
               Integer priority) {

        this.id = id;
        this.product = product;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = currency;
        this.priority = priority;
    }

    public PVP() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ListPrice getPrice() {
        return price;
    }

    public void setPrice(ListPrice price) {
        this.price = price;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
