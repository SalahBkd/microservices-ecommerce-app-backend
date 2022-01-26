package me.salahbkd.billingservice.repository;

import me.salahbkd.billingservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findByName(String name);
}
