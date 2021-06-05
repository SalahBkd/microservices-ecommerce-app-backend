package me.salahbkd.billingservice.web;

import me.salahbkd.billingservice.entity.Bill;
import me.salahbkd.billingservice.fiegn.CustomerRestClient;
import me.salahbkd.billingservice.fiegn.ProductItemRestClient;
import me.salahbkd.billingservice.model.Customer;
import me.salahbkd.billingservice.model.Product;
import me.salahbkd.billingservice.repository.BillRepository;
import me.salahbkd.billingservice.repository.ProductItemRepository;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;

    public BillingRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productItemRestClient = productItemRestClient;
    }

    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id")  Long id) {
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerRestClient.getCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(productItem -> {
            Product product = productItemRestClient.getPrductById(productItem.getProductId());
            productItem.setProduct(product);
        });
        return bill;
    }
}
