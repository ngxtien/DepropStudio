package com.example.depropdemo.Controller;

import com.example.depropdemo.Model.Category;
import com.example.depropdemo.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {
    @Autowired
    private CategoryService categoryService;


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
    public String add_category(@ModelAttribute("category") Category category,
            Model model){
//        Category category = new Category();
//        model.addAttribute("category", category);
        categoryService.save(category);
        return "redirect:/dashboard/category";
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
}
