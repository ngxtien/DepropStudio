package com.example.depropdemo.Dao;

import com.example.depropdemo.Model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByProducts_Id(Long productId);

}
