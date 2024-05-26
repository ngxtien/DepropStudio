package com.example.depropdemo.Dao;

import com.example.depropdemo.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
