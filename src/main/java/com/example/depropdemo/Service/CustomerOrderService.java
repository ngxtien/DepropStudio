package com.example.depropdemo.Service;

import com.example.depropdemo.Dao.CustomerOrderRepository;
import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Model.CustomerOrder;
import com.example.depropdemo.Model.DTO.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerOrderService {
    private final CustomerOrderRepository customerOrderRepository;

    @Autowired
    public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrderRepository.findAll();
    }

    public Optional<CustomerOrder> getCustomerOrderById(Long id) {
        return customerOrderRepository.findById(id);
    }

    public CustomerOrder saveOrUpdateCustomerOrder(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }
    public Integer getOrderId(){
        List<CustomerOrder> orderId = getAllCustomerOrders();
        return orderId.get(orderId.size() - 1).getOrderId();
    }
    public void deleteCustomerOrderById(Long id) {
        customerOrderRepository.deleteById(id);
    }

    public Long getTotalSaleaday(){
        return customerOrderRepository.totalSalesaday();
    }
    public Long getTotalSale(){
        return customerOrderRepository.totalSale();
    }
}

