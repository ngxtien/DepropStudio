package com.example.depropdemo.Dao;

import com.example.depropdemo.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}