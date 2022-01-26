package me.salahbkd.billingservice.repository;

import me.salahbkd.billingservice.entity.Customer;
import me.salahbkd.billingservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
}
