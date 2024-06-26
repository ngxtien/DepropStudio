package com.example.depropdemo.Controller;

import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.mail.EmailSender;
import com.example.depropdemo.mail.BillConfirmTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;


@Controller
public class BillConfirmController {

    @Autowired
    private EmailSender gmailSender;

    @GetMapping("/mailSender")
    public String formBill(Model model) {
        model.addAttribute("customer", new Customer());
        return "Test/mailSender";
    }

    @PostMapping("/sendBill")
    public String proccesingBill(Customer customer) {
        String template = BillConfirmTemplate.getTemplate(customer, getDay(), getDayExp());
        Thread emailThread = new Thread(() -> {
            try {
                gmailSender.send(template, customer.getEmail());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        emailThread.start();
        return "redirect:/mailSender";
    }

    public String getDay() {
        //Right now
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dayOfWeek = dateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("vi", "VN"));
        dayOfWeek = dayOfWeek.substring(0, 1).toLowerCase() + dayOfWeek.substring(1);
        String formattedDateTime = String.format("%s %s, %s",
                dateTime.format(timeFormatter), dayOfWeek, dateTime.format(dateFormatter));
        System.out.println(formattedDateTime);
        return formattedDateTime;
    }

    public String getDayExp() {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime dateTimeExp = dateTime.plusDays(3);
        DateTimeFormatter dateFormatterExp = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dayOfWeekExp = dateTimeExp.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("vi", "VN"));
        dayOfWeekExp = dayOfWeekExp.substring(0, 1).toUpperCase() + dayOfWeekExp.substring(1);
        String formattedDateExp = String.format("%s, %s", dayOfWeekExp, dateTimeExp.format(dateFormatterExp));
        System.out.println(formattedDateExp);
        return formattedDateExp;
    }
}