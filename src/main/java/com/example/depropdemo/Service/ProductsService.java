package com.example.depropdemo.Service;

import com.example.depropdemo.Dao.ProductsRepository;
import com.example.depropdemo.Model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public Optional<Products> getProductById(Long id) {
        return productsRepository.findById(id);
    }

    public Products saveProduct(Products products) {
        return productsRepository.save(products);
    }

    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }
//
//    public String getStatus(){
//        return productsRepository.f
//    }
}
