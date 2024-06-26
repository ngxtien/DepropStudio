package com.example.depropdemo.Controller;

import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Service.CustomerService;
import com.example.depropdemo.mail.BillConfirmTemplate;
import com.example.depropdemo.mail.EmailSender;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lib.payos.PayOS;
import com.lib.payos.type.ItemData;
import com.lib.payos.type.PaymentData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.Locale;

@Controller
public class CheckoutController {

    private final PayOS payOS;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmailSender gmailSender;

    public CheckoutController(PayOS payOS) {
        super();
        this.payOS = payOS;
    }

    @RequestMapping(value = "/check-out")
    public String Index(Model model) {
        model.addAttribute("customer", new Customer());
        return "user/checkout";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create-payment-link", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void checkout(HttpServletResponse httpServletResponse, HttpSession session,Customer customer) {
        customerService.saveCustomer(customer);
        session.setAttribute("customer", customer);
        try {
            final String productName = "1 vé đi về tủi ther";
            final String description = "Thanh toan don hang";
            final String returnUrl = "http://localhost:8080/order-success";
            final String cancelUrl = "http://localhost:8080/order-fail";
            final int price = 2000;
            String currentTimeString = String.valueOf(new Date().getTime());
            int orderCode = Integer.parseInt(currentTimeString.substring(currentTimeString.length() - 6));
            ItemData item = new ItemData(productName, 1, price);
            List<ItemData> itemList = new ArrayList<>();
            itemList.add(item);
            PaymentData paymentData = new PaymentData(orderCode, price, description,
                    itemList, cancelUrl, returnUrl);
            JsonNode data = payOS.createPaymentLink(paymentData);
            String checkoutUrl = data.get("checkoutUrl").asText();
            httpServletResponse.setHeader("Location", checkoutUrl);
            httpServletResponse.setStatus(302);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/order-success", method = RequestMethod.GET)
    public String orderSuccess(HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
//            String template = BillConfirmTemplate.getTemplate(customer, getDay(), getDayExp());
            Thread emailThread = new Thread(() -> {
                try {
//                    gmailSender.send(template, customer.getEmail());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            emailThread.start();
            customerService.delete(customer.getId());
            session.removeAttribute("customer");
            return "user/order-success";
        }
        return "redirect:/404";
    }

    @RequestMapping(value = "/order-fail", method = RequestMethod.GET)
    public String orderFailure(HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            session.removeAttribute("customer");
            return "user/order-failure";
        }
        return "redirect:/404";
    }

//    public String getDay() {
//        //Right now
//        LocalDateTime dateTime = LocalDateTime.now();
//        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String dayOfWeek = dateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("vi", "VN"));
//        dayOfWeek = dayOfWeek.substring(0, 1).toLowerCase() + dayOfWeek.substring(1);
//        String formattedDateTime = String.format("Đơn hàng của bạn đặt vào %s %s, %s",
//                dateTime.format(timeFormatter), dayOfWeek, dateTime.format(dateFormatter) + 1);
//        System.out.println(formattedDateTime);
//        return formattedDateTime;
//    }
//
//    public String getDayExp() {
//        LocalDateTime dateTime = LocalDateTime.now();
//        LocalDateTime dateTimeExp = dateTime.plusDays(3);
//        DateTimeFormatter dateFormatterExp = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String dayOfWeekExp = dateTimeExp.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("vi", "VN"));
//        dayOfWeekExp = dayOfWeekExp.substring(0, 1).toUpperCase() + dayOfWeekExp.substring(1);
//        String formattedDateExp = String.format("%s, %s", dayOfWeekExp, dateTimeExp.format(dateFormatterExp));
//        System.out.println(formattedDateExp);
//        return formattedDateExp;
//    }
}