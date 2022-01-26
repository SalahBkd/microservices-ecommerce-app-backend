package me.salah.customerservice;

import me.salah.customerservice.entity.Customer;
import me.salah.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

//    @Bean
//    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
//        repositoryRestConfiguration.exposeIdsFor(Customer.class); // WE NEED CUSTOMER IDs
//        return args -> {
//            customerRepository.save(new Customer(null, "salah", "salah@gmail.com"));
//            customerRepository.save(new Customer(null, "yusuf", "yusuf@gmail.com"));
//            customerRepository.save(new Customer(null, "ousama", "ousama@gmail.com"));
//            customerRepository.findAll().forEach(customer -> System.out.println(customer.toString()));
//        };
//    }

}
