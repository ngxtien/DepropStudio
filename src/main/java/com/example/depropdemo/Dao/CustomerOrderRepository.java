package com.example.depropdemo.Dao;

import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Model.CustomerOrder;
import com.example.depropdemo.Model.DTO.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

    @Query(value = "SELECT SUM(co.totalprice - 50000) AS total_sales FROM customer_order co WHERE DATE(co.order_date) = CURDATE();", nativeQuery = true)
    Long totalSalesaday();

    @Query(value = "SELECT SUM(co.totalprice - 50000) AS total_sales FROM customer_order co;", nativeQuery = true)
    Long totalSale();
    Optional<CustomerOrder> findAllByOrderId(Long id);
}
