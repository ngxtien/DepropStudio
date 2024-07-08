package com.example.depropdemo.Service;

import com.example.depropdemo.Dao.CategoryRepository;
import com.example.depropdemo.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Category save(Category category){
        return  categoryRepository.save(category);
    }

}
