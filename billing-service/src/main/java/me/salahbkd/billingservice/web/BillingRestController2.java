package me.salahbkd.billingservice.web;

import lombok.AllArgsConstructor;
import me.salahbkd.billingservice.dto.BuyProductsDto;
import me.salahbkd.billingservice.entity.*;
import me.salahbkd.billingservice.repository.BillRepository;
import me.salahbkd.billingservice.repository.CustomerRepo;
import me.salahbkd.billingservice.repository.ProductItemRepository;
import me.salahbkd.billingservice.repository.ProductRepo;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class BillingRestController2 {
    private CustomerRepo customerRepo;
    private ProductRepo productRepo;
    private ProductItemRepository productItemRepository;
    private BillRepository billRepository;

    @PostMapping("/generateBill")
    public Bill buyProducts(@RequestBody BuyProductsDto buyProductsDto) {
//        System.out.println(buyProductsDto);
//        List<ProductGetRequest> dtoProducts = buyProductsDto.getCustomerProducts();
//        List<Product> productsList = new ArrayList<>();
//        Customer customer = customerRepo.findByName(buyProductsDto.getCustomerName());
//        dtoProducts.forEach(product -> {
//            productsList.add(productRepo.findByName(product.getProductName()));
//        });
//
//        Bill bill = billRepository.save(new Bill(null, new Date(), null, customer.getId(), null));
//
//        productsList.forEach(product -> {
//                ProductItem productItem = new ProductItem();
//                productItem.setPrice(product.getPrice());
//                productItem.setQuantity(product.getQuantity());
//                productItem.setProductId(product.getId());
//                productItem.setBill(bill);
//                productItemRepository.save(productItem);
//            });
//        return bill;
        Customer customer = customerRepo.findByName(buyProductsDto.getCustomerName());
        List<ProductGetRequest> dtoProducts = buyProductsDto.getCustomerProducts();
        List<ProductItem> items = new ArrayList<>();
        Bill bill = billRepository.save(new Bill(null, new Date(), null, customer.getId(), null));
        List<Product> productsList = new ArrayList<>();

        dtoProducts.forEach(product -> {
            productsList.add(productRepo.findByName(product.getProductName()));
        });

        productsList.forEach(product -> {
            ProductItem productItem = new ProductItem();
            productItem.setPrice(product.getPrice());
            productItem.setQuantity(product.getQuantity());
            productItem.setBill(bill);
            productItem.setProductId(product.getId());

            items.add(productItem);
            productItemRepository.save(productItem);
        });

        bill.setCustomer(customer);
        bill.setProductItems(items);

        return bill;
    }
    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id")  Long id) {
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerRepo.findById(bill.getCustomerId()).get();
        bill.setCustomer(customer);
        bill.getProductItems().forEach(productItem -> {
            Product product = productRepo.findById(productItem.getProductId()).get();
            productItem.setProduct(product);
        });
        return bill;
    }
}
