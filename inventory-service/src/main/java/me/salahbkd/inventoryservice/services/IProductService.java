package me.salahbkd.inventoryservice.services;

import me.salahbkd.inventoryservice.entities.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void deleteById(Long id);
}
