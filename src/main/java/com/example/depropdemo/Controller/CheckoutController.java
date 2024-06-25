package com.example.depropdemo.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lib.payos.PayOS;
import com.lib.payos.type.ItemData;
import com.lib.payos.type.PaymentData;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class CheckoutController {
//  private final PayOS payOS;
//  public CheckoutController(PayOS payOS) {
//    super();
//    this.payOS = payOS;
//  }
//    @RequestMapping(value = "/check-out")
//    public String Index() {
//        return "index";
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/create-payment-link", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public void checkout(HttpServletResponse httpServletResponse) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            final String productName = "1 vé đi về tủi ther";
//            final String description = "Thanh toan don hang";
//            final String returnUrl = "http://localhost:8080/order-success";
//            final String cancelUrl = "http://localhost:8080/order-fail";
//            final int price = 2000;
//            String currentTimeString = String.valueOf(new Date().getTime());
//            int orderCode = Integer.parseInt(currentTimeString.substring(currentTimeString.length() - 6));
//            ItemData item = new ItemData(productName, 1, price);
//            List<ItemData> itemList = new ArrayList<>();
//            itemList.add(item);
//            PaymentData paymentData = new PaymentData(orderCode, price, description,
//              itemList, cancelUrl, returnUrl);
//            JsonNode data = payOS.createPaymentLink(paymentData);
//            String checkoutUrl = data.get("checkoutUrl").asText();
//            httpServletResponse.setHeader("Location", checkoutUrl);
//            httpServletResponse.setStatus(302);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    @RequestMapping(value = "/order-success", method = RequestMethod.GET)
//    public String orderSuccess(@RequestParam(required = false) String status) {
//        if ("PAID".equals(status)) {
//            return "user/order-success";
//        }
//        return "redirect:/404";
//    }

//    @RequestMapping(value = "/order-fail", method = RequestMethod.GET)
//    public String orderFailure(@RequestParam(required = false) String status) {
//        if ("CANCELLED".equals(status)) {
//            return "user/order-failure";
//        }
//        return "redirect:/404";
//    }

}