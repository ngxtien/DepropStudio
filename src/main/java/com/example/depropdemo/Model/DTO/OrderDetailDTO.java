package com.example.depropdemo.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDetailDTO {
        @JsonProperty("id")
        private Long productId;
        private Integer quantity;
        private Double price;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}



