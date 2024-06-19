package com.example.depropdemo.Controller;

import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/check-out")
    public String Customer_checkout(Model model){
        model.addAttribute("customer", new Customer());
        return "user/checkout";
    }

    @PostMapping("/check-out")
    public String submitForm(@ModelAttribute("customer") Customer customer,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/order-failure";
        }
        customerService.saveCustomer(customer);
        return "redirect:user/order_success"; //
    }

}
