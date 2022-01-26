//package me.salahbkd.billingservice.fiegn;
//
//import me.salahbkd.billingservice.model.Customer;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestHeader;
//
//@FeignClient(name = "CUSTOMER-SERVICE") // OpenFeign library that allows to use declarative REST communication
//public interface CustomerRestClient {
//    @GetMapping(path = "/customers/{id}")
//    Customer getCustomerById(@PathVariable(name = "id") Long id, @RequestHeader("Authorization") String authorizationToken);
//
//}
