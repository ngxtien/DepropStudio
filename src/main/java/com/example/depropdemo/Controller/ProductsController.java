package com.example.depropdemo.Controller;

import com.example.depropdemo.Model.Products;
import com.example.depropdemo.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Products> products = productsService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("product", new Products());
        return "products";
    }
    // add thi product (khong co "s"), show thi co
    @PostMapping("/products")
    public String addProduct(@ModelAttribute("product") Products product){
        productsService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete-products/{ids}")
    public String deleteProducts(@PathVariable String ids) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            productsService.deleteProduct(Long.parseLong(id));
        }
        return "redirect:/products";
    }

    @GetMapping("/update-products/{id}")
    public String updateProducts(@PathVariable Long id, Model model){
        Optional<Products> productExisting = productsService.getProductById(id);
        model.addAttribute("product", productExisting.orElse(new Products()));

//        String[] idArray = ids.split(",");
//        for (String id : idArray) {
//            productsService.getProductById(Long.parseLong(ids));
//        }
        return "products";
    }

    @PostMapping("/update-products/{id}")
    public String updateProducts(@PathVariable("id") Long id, @ModelAttribute("product") Products product){
        product.setId(id);
        productsService.saveProduct(product);
        return "redirect:/products";
    }

}