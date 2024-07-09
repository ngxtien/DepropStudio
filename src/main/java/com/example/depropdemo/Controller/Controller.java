package com.example.depropdemo.Controller;

import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Model.Products;
import com.example.depropdemo.Service.CategoryService;
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

    @Autowired
    private CategoryService categoryService;

//////////         USER            ////////////////

    @GetMapping("/check-out")
    public String Customer_checkout(Model model){
        model.addAttribute("customer", new Customer());
        return "user/checkout";
    }

    @GetMapping("/404")
    public String Error_page(){
        return "user/404";
    }

    @GetMapping("/category")
    public String User_category(Model model){
        model.addAttribute("product", productsService.getAllProducts());
        return "user/category";
    }

    @GetMapping("/combo")
    public String User_combo(Model model){
        model.addAttribute("product", productsService.getAllProducts());
        return "user/combo";
    }

    @GetMapping("/contact")
    public String User_contact(){
        return "user/contact";
    }

    @GetMapping("/")
    public String User_index(){
        return "user/index";
    }

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
