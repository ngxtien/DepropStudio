package com.example.depropdemo.Controller;

import com.example.depropdemo.Dao.OrderDetailRepository;
import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Model.DTO.OrderDetailDTO;
import com.example.depropdemo.Model.DTO.OrderRequestDTO;
import com.example.depropdemo.Model.OrderDetail;
import com.example.depropdemo.Service.CheckoutService;
import com.example.depropdemo.Service.CustomerService;
import com.example.depropdemo.Service.OrderDetailService;
import com.example.depropdemo.Service.ProductsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lib.payos.PayOS;
import com.lib.payos.type.ItemData;
import com.lib.payos.type.PaymentData;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/check-out")
public class CheckoutController {

    private final PayOS payOS;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CheckoutService checkoutService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ProductsService productsService;

    @Autowired
    public CheckoutController(OrderDetailRepository orderDetailRepository, PayOS payOS) {
        super();
        this.payOS = payOS;
        this.orderDetailRepository = orderDetailRepository;
    }

    // Endpoint to handle adding order details
    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(@RequestBody OrderRequestDTO orderRequestDTO, HttpSession session) {
        session.setAttribute("OrderRequestDT", orderRequestDTO);
        session.setAttribute("customer1", orderRequestDTO.getCustomerData());
        orderDetailService.processOrder(orderRequestDTO);
        return ResponseEntity.ok("Added to cart successfully");
    }

    @PostMapping("/create-payment-link")
    public ResponseEntity<?> checkout(@RequestBody OrderRequestDTO orderRequestDTO, HttpSession session) {
        session.setAttribute("OrderRequestDTO", orderRequestDTO);
        session.setAttribute("customer", orderRequestDTO.getCustomerData());
        List<OrderDetailDTO> orderList = orderRequestDTO.getCartData();
        try {
            final String description = "Thanh toan don hang";
            final String returnUrl = "https://depropstudio.art/order-success-bank";
            final String cancelUrl = "https://depropstudio.art/order-fail";
            String currentTimeString = String.valueOf(new Date().getTime());
            int orderCode = Integer.parseInt(currentTimeString.substring(currentTimeString.length() - 6));
            List<ItemData> itemList = new ArrayList<>();
            int totalPrice = 0;
            int rentDay = orderRequestDTO.calculateDurationInDays();
            for (OrderDetailDTO o : orderList) {
                String productName = productsService.getProductById(o.getProductId()).get().getName();
                int quantity = o.getQuantity();
                double pricedoub = o.getPrice();
                int price = (int) pricedoub;
                ItemData item = new ItemData(productName, quantity, price);
                itemList.add(item);
                totalPrice += (price * quantity) * (rentDay - 1) + 50000;
            }
            orderDetailService.processOrder(orderRequestDTO);
            PaymentData paymentData = new PaymentData(orderCode, totalPrice, description,
                    itemList, cancelUrl, returnUrl);
            JsonNode data = payOS.createPaymentLink(paymentData);
            String checkoutUrl = data.get("checkoutUrl").asText();
            return ResponseEntity.ok().body(Map.of("checkoutUrl", checkoutUrl));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
