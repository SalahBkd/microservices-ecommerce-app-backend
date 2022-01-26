package me.salah.customerservice.controller;

import lombok.AllArgsConstructor;
import me.salah.customerservice.entity.Customer;
import me.salah.customerservice.services.CustomerService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;
    StreamBridge streamBridge;
    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable Long customerId) {
        var customer =  customerService.findById(customerId);

        if(customer == null)
            throw new RuntimeException("customer not found with id: " + customerId);

        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        final String topicName = "customer_topic";
        customerService.save(customer);
        streamBridge.send(topicName, customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
        var customer = customerService.findById(customerId);

        if(customer == null)
            throw new RuntimeException("customer id not found " + customerId);

        customerService.deleteById(customerId);

        return "deleted customer with id" + customerId;
    }
}
