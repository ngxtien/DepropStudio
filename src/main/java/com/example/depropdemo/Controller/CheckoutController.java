package com.example.depropdemo.Controller;

import com.example.depropdemo.Dao.OrderDetailRepository;
import com.example.depropdemo.Model.OrderDetail;
import com.example.depropdemo.Model.Request.AddToCartRequest;
import com.example.depropdemo.Service.CheckoutService;
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
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequestMapping("/check-out")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    public CheckoutController(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    // Endpoint to handle adding order details
    @PostMapping("/check-out/add-to-cart")
    public ResponseEntity<?> addToCart(@RequestBody AddToCartRequest addToCartRequest) {

        List<OrderDetail> cartData = addToCartRequest.getCartData();
        String startDate = addToCartRequest.getStartDate();
        String endDate = addToCartRequest.getEndDate();

        // Call service to process and save cart data
        checkoutService.addToCart(cartData, startDate, endDate);
        return ResponseEntity.ok("Cart data added successfully");
    }


}
