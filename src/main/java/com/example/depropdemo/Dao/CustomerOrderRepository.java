package com.example.depropdemo.Dao;

import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
