package com.example.depropdemo.Controller;

import com.example.depropdemo.Model.Products;
import com.example.depropdemo.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/dashboard")
    public String adminindex(){
        return "/admin/index";
    }

    @GetMapping("/dashboard/login")
    public String login(){
        return "/admin/login";
    }

    @GetMapping("/dashboard/add-product")
    public String Add_product(){
        return "/admin/add_product";
    }

    @GetMapping("/dashboard/update-product")
    public String update_product(){
        return "/admin/edit_product";
    }

    @GetMapping("/dashboard/product")
    public String Dashboard_product(){
        return "/admin/product";
    }

//////////         USER            ////////////////

    @GetMapping("/404")
    public String Error_page(){
        return "user/404";
    }

    @GetMapping("/category")
    public String User_category(Model model){
        model.addAttribute("product", productsService.getAllProducts());
        return "user/category";
    }

    @GetMapping("/contact")
    public String User_contact(){
        return "user/contact";
    }

    @GetMapping("/")
    public String User_index(){
        return "user/index";
    }

//    @GetMapping("/ordersuccess")
//    public String User_ordersuccess(){
//        return "success";
//    }

    @GetMapping("/policy")
    public String User_policy(){
        return "user/policy";
    }

    @GetMapping("/product/{id}")
    public String User_product(@PathVariable String id, Model model){
        Optional<Products> productOptional = productsService.getProductById(Long.parseLong(id));
        if (productOptional.isPresent()) {
            model.addAttribute("product", productOptional.get());
        } else {
            return "redirect:/404"; // Hoặc một trang lỗi phù hợp
        }
        return "user/product";
    }

    @GetMapping("/cart")
    public String User_cart(Model model){
        return "user/cart";
    }
}
