package me.salah.customerservice.services;

import me.salah.customerservice.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    void save(Customer product);
    void deleteById(Long id);
}
