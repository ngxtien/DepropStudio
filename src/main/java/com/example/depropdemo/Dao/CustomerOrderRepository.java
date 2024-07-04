package com.example.depropdemo.Dao;

import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Model.CustomerOrder;
import com.example.depropdemo.Model.DTO.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
