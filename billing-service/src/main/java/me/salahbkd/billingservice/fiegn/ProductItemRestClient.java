package me.salahbkd.billingservice.fiegn;

import me.salahbkd.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductItemRestClient {
    @GetMapping(path = "/products")
    PagedModel<Product> getPageProducts();
    @GetMapping(path = "/products/{id}")
    Product getPrductById(@PathVariable(name = "id") Long id);
}
