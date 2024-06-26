package com.example.depropdemo.Model.Request;

import com.example.depropdemo.Model.OrderDetail;

import java.util.List;

public class AddToCartRequest {
    private List<OrderDetail> cartData;
    private String startDate;
    private String endDate;

    public AddToCartRequest() {}

    public List<OrderDetail> getCartData() {
        return cartData;
    }

    public void setCartData(List<OrderDetail> cartData) {
        this.cartData = cartData;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

