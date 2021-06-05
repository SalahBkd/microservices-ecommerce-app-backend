package me.salahbkd.billingservice;

import me.salahbkd.billingservice.entity.Bill;
import me.salahbkd.billingservice.entity.ProductItem;
import me.salahbkd.billingservice.fiegn.CustomerRestClient;
import me.salahbkd.billingservice.fiegn.ProductItemRestClient;
import me.salahbkd.billingservice.model.Customer;
import me.salahbkd.billingservice.model.Product;
import me.salahbkd.billingservice.repository.BillRepository;
import me.salahbkd.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository
            productItemRepository, CustomerRestClient customerRestClient,
                            ProductItemRestClient productItemRestClient) {
        return args -> {
            Customer customer = customerRestClient.getCustomerById(1L);
            Bill bill = billRepository.save(new Bill(null, new Date(), null, customer.getId(), null));
            PagedModel<Product> productPageModel = productItemRestClient.getPageProducts();
            productPageModel.forEach(product -> {
                ProductItem productItem = new ProductItem();
                productItem.setPrice(product.getPrice());
                productItem.setQuantity(1 + new Random().nextInt(100));
                productItem.setBill(bill);
                productItem.setProductId(product.getId());
                productItemRepository.save(productItem);
            });
        };
    }

}
