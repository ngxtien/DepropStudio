package com.example.depropdemo.Model.DTO;

import java.util.List;
import com.example.depropdemo.Model.Customer;

public class OrderRequestDTO {
    private List<OrderDetailDTO> cartData;
    private String startDate;
    private String endDate;
    private CustomerDTO customerData;

    public CustomerDTO getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerDTO customerData) {
        this.customerData = customerData;
    }


    //    public Customer getCustomer() {
//        return customerData;
//    }

//    public void setCustomer(Customer customer) {
//        this.customerData = customer;
//    }

    public List<OrderDetailDTO> getCartData() {
        return cartData;
    }

    public void setCartData(List<OrderDetailDTO> cartData) {
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
