package com.example.depropdemo.Controller;

import com.example.depropdemo.mail.EmailSender;
import com.example.depropdemo.mail.BillConfirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BillConfirmController {

    @Autowired
    private EmailSender gmailSender;

    @GetMapping("/mailSender")
    public String formBill(){
        return "mailSender";
    }

    @PostMapping("/sendBill")
    public String proccesingBill(@RequestParam(value = "email") String email) {
        String template = BillConfirm.getTemplete("thaideptrai");
        Thread emailThread = new Thread(() -> {
            try {
                gmailSender.send(template, email);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        emailThread.start();
        return "redirect:/login";
    }
}