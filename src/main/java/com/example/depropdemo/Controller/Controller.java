package com.example.depropdemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/dashboard")
    public String adminindex(){
        return "admin/index";
    }

    @GetMapping("dashboard/login")
    public String login(){
        return "admin/login";
    }

    @GetMapping("dashboard/add-product")
    public String Add_product(){
        return "admin/add_product";
    }

    @GetMapping("dashboard/update-product")
    public String update_product(){
        return "admin/edit_product";
    }

    @GetMapping("dashboard/product")
    public String Dashboard_product(){
        return "admin/product";
    }

//////////         USER            ////////////////

    @GetMapping("/404")
    public String Error_page(){
        return "user/404";
    }

    @GetMapping("/user-cart")
    public String User_cart(){
        return "user/cart";
    }

    @GetMapping("/user-category")
    public String User_category(){
        return "user/category";
    }

    @GetMapping("/user-checkout")
    public String User_checkout(){
        return "user/checkout";
    }

    @GetMapping("/user-contact")
    public String User_contact(){
        return "user/checkout";
    }

    @GetMapping("/user")
    public String User_index(){
        return "user/index";
    }

    @GetMapping("/user-orderfail")
    public String User_orderfailed(){
        return "user/order-failure";
    }

    @GetMapping("/user-ordersuccess")
    public String User_ordersuccess(){
        return "user/order-success";
    }

    @GetMapping("/user-policy")
    public String User_policy(){
        return "user/policy";
    }

    @GetMapping("/user-singleproduct")
    public String User_singleproduct(){
        return "user/single-product";
    }
}
