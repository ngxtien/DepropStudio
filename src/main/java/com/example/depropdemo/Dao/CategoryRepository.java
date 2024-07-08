package com.example.depropdemo.Dao;

import com.example.depropdemo.Model.Category;
import com.example.depropdemo.Model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
