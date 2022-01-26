package me.salahbkd.inventoryservice;

import me.salahbkd.inventoryservice.entities.Product;
import me.salahbkd.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

//    @Bean
//    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
//        repositoryRestConfiguration.exposeIdsFor(Product.class);
//        return args -> {
//            productRepository.save(new Product(null, "laptop", "description1", 234, 423));
//            productRepository.save(new Product(null, "smartphone", "description2", 323, 345));
//            productRepository.save(new Product(null, "product3", "description3", 390, 349));
//            productRepository.save(new Product(null, "product4", "description4", 234, 423));
//            productRepository.findAll().forEach(System.out::println);
//        };
//    }
}

