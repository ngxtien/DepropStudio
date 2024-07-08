package com.example.depropdemo.Controller;

import com.example.depropdemo.Model.Category;
import com.example.depropdemo.Model.Products;
import com.example.depropdemo.Service.CategoryService;
import com.example.depropdemo.Service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Controller
public class DashboardController {
    @Autowired
    private CategoryService categoryService;

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

    @GetMapping("/dashboard/category")
    public String category(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("category", new Category());
        return "admin/category";
    }

    @PostMapping("/dashboard/category")
    public String add_category(@Valid @ModelAttribute("category") Category category,
                               BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategory());
            return "admin/category";
        }
        categoryService.save(category);
        return "redirect:/dashboard/category";
    }

    @GetMapping("/dashboard/add-product")
    public String Add_product(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("product", new Products());
        return "admin/add_product";
    }

    @PostMapping("/dashboard/add-product")
    public String Add_product_p(@Valid @ModelAttribute("product") Products products,
                                BindingResult result, Model model,
                                @RequestParam(value = "imaged", required = false) MultipartFile imageFile){
        if (!imageFile.isEmpty()) {
            try {
                byte[] imageBytes = imageFile.getBytes();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                products.setImage(base64Image);
            } catch (IOException e) {
                e.printStackTrace();
                // Xử lý lỗi lưu ảnh
                return "redirect:/dashboard/add-product";
            }
        }
        productsService.saveProduct(products);
        return "admin/add_product";
    }


    @GetMapping("/dashboard/update-product/{id}")
    public String update_product(@PathVariable("id") Long id, Model model){
        Optional<Products> productExisting = productsService.getProductById(id);
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("product", productExisting.orElse(new Products()));
        return "admin/edit_product";
    }

    @PostMapping("/dashboard/update-product/{id}")
    public String update_Product_p(@PathVariable("id") Long id, Model model,
                                 @ModelAttribute("product") Products product,
                                 @RequestParam("image-update") MultipartFile imageFile) throws IOException {
        product.setId(id);
        if (!imageFile.isEmpty()) {
            byte[] imageBytes = imageFile.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            product.setImage(base64Image);
        }
        productsService.saveProduct(product);
        return "redirect:/dashboard/product";
    }



    @GetMapping("/dashboard/product")
    public String Dashboard_product(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("product", productsService.getAllProducts());
        return "admin/product";
    }
}
