package com.example.depropdemo.Controller;

import com.example.depropdemo.Dao.OrderDetailRepository;
import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Model.DTO.OrderRequestDTO;
import com.example.depropdemo.Model.OrderDetail;
import com.example.depropdemo.Service.CheckoutService;
import com.example.depropdemo.Service.CustomerService;
import com.example.depropdemo.Service.OrderDetailService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lib.payos.PayOS;
import com.lib.payos.type.ItemData;
import com.lib.payos.type.PaymentData;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequestMapping("/check-out")
public class CheckoutController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CheckoutService checkoutService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    public CheckoutController(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    // Endpoint to handle adding order details
    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(@RequestBody OrderRequestDTO orderRequestDTO) {
        orderDetailService.processOrder(orderRequestDTO);
        return ResponseEntity.ok("Order processed successfully");
    }

}
