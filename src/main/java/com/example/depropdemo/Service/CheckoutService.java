package com.example.depropdemo.Service;

import com.example.depropdemo.Dao.CustomerRepository;
import com.example.depropdemo.Dao.ProductsRepository;
import com.example.depropdemo.Dao.OrderDetailRepository;
import com.example.depropdemo.Model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderDetailService orderDetailService;


    public void addToCart(List<OrderDetail> cartData, String startDate, String endDate) {
        for (OrderDetail orderDetail : cartData) {
            orderDetailService.saveOrderDetail(orderDetail);
        }
    }

}
