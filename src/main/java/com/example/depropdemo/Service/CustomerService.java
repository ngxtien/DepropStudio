package com.example.depropdemo.Service;

import com.example.depropdemo.Dao.CustomerRepository;
import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getProductById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteProduct(Long id) {
        customerRepository.deleteById(id);
    }

    public void delete(Long id){customerRepository.deleteById(id);}

}
