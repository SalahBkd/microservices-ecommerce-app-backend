//package me.salahbkd.billingservice.fiegn;
//
//import me.salahbkd.billingservice.model.Product;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.hateoas.PagedModel;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//
//@FeignClient(name = "INVENTORY-SERVICE") // OpenFeign library that allows to use declarative REST communication
//public interface ProductItemRestClient {
//    @GetMapping(path = "/products")
//    PagedModel<Product> getPageProducts(@RequestHeader("Authorization") String authorizationToken);
//    @GetMapping(path = "/products/{id}")
//    Product getPrductById(@PathVariable(name = "id") Long id, @RequestHeader("Authorization") String authorizationToken);
//}
