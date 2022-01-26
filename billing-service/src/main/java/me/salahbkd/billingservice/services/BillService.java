package me.salahbkd.billingservice.services;

import lombok.AllArgsConstructor;
import me.salahbkd.billingservice.entity.Customer;
import me.salahbkd.billingservice.entity.Product;
import me.salahbkd.billingservice.repository.CustomerRepo;
import me.salahbkd.billingservice.repository.ProductRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@AllArgsConstructor
public class BillService {
    private CustomerRepo customerRepo;
    private ProductRepo productRepo;

    @Bean
    public Consumer<Product> productEventConsumer() {
        return (input) -> {
            System.out.println("=======================");
            System.out.println(input.toString());
            System.out.println("=======================");
            productRepo.save(input);
        };
    }
    @Bean
    public Consumer<Customer> customerEventConsumer() {
        return (input) -> {
            System.out.println("=======================");
            System.out.println(input.toString());
            System.out.println("=======================");
            customerRepo.save(input);
        };
    }
}
