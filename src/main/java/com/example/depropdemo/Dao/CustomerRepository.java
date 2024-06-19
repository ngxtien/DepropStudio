package com.example.depropdemo.Dao;

import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
