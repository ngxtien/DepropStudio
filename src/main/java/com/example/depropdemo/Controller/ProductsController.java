package com.example.depropdemo.Controller;

import com.example.depropdemo.Model.Products;
import com.example.depropdemo.Service.CartService;
import com.example.depropdemo.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService productsService;
//
//    @Autowired
//    private CartService cartService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("product", productsService.getAllProducts());
        return "/index";
    }

    @GetMapping("/category")
    public String category(Model model){
        model.addAttribute("product", productsService.getAllProducts());
        return "/category";
    }

    @GetMapping("/product_detail/{id}")
        public String productsDetail(@PathVariable String id, Model model){
        Optional<Products> productOptional = productsService.getProductById(Long.parseLong(id));
        if (productOptional.isPresent()) {
            model.addAttribute("product", productOptional.get());
        } else {
            return "redirect:/products"; // Hoặc một trang lỗi phù hợp
        }
        return "/product_detail";
    }



    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Products> products = productsService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("product", new Products());
        return "products";
    }
    // add thi product (khong co "s"), show thi co
    @PostMapping("/products")
    public String addProduct(@ModelAttribute("product") Products product,
                             @RequestParam(value = "imaged", required = false) MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            try {
                byte[] imageBytes = imageFile.getBytes();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                product.setImage(base64Image);
            } catch (IOException e) {
                e.printStackTrace();
                // Xử lý lỗi lưu ảnh
                return "redirect:/products";
            }
        }
        productsService.saveProduct(product);
        return "redirect:/products";
    }


//    =========================================================================
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
        return "update-products";
    }

    @PostMapping("/update-products/{id}")
    public String updateProducts(@PathVariable("id") Long id, Model model,
                                 @ModelAttribute("product") Products product,
                                 @RequestParam("image-update") MultipartFile imageFile) throws IOException {
        product.setId(id);
        if (!imageFile.isEmpty()) {
            byte[] imageBytes = imageFile.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            product.setImage(base64Image);
        }
        productsService.saveProduct(product);
        return "redirect:/products";
    }

//
    @GetMapping("/product/{id}")
    public String getProductDetail(@PathVariable Long id, Model model) {
        Optional<Products> product = productsService.getProductById(id);
        model.addAttribute("product", product.orElse(new Products()));
        return "product_detail";
    }


}