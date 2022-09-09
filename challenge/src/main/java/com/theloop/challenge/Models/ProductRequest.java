package com.theloop.challenge.Models;

import java.time.LocalDateTime;

public class ProductRequest {

    private LocalDateTime date;
    private int productId;
    private int brandId;

    public ProductRequest() {
    }

    public ProductRequest(LocalDateTime date, int productId, int brandId) {
        this.date = date;
        this.productId = productId;
        this.brandId = brandId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getProductId() {
        return productId;
    }

    public int getBrandId() {
        return brandId;
    }
}
