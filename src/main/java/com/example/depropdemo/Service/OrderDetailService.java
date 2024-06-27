package com.example.depropdemo.Service;

import com.example.depropdemo.Dao.OrderDetailRepository;
import com.example.depropdemo.Dao.ProductsRepository;
import com.example.depropdemo.Model.OrderDetail;
import com.example.depropdemo.Model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private ProductsRepository productsRepository;


    @Autowired
    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public void saveOrderDetail(OrderDetail orderDetail, String startDate, String endDate) {
        Products product = productsRepository.findById(orderDetail.getProductID()).orElseThrow(() -> new IllegalArgumentException("Product not found"));

        orderDetail.setProduct(product);
        orderDetail.setStartDate(startDate);
        orderDetail.setEndDate(endDate);
        orderDetailRepository.save(orderDetail);

    }
}
