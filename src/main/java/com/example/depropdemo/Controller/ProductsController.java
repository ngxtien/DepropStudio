package com.example.depropdemo.Controller;

import com.example.depropdemo.Model.Products;
import com.example.depropdemo.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Products> products = productsService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }
}
