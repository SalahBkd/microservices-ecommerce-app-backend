package me.salahbkd.inventoryservice.controllers;

import lombok.AllArgsConstructor;
import me.salahbkd.inventoryservice.dtos.ProductDto;
import me.salahbkd.inventoryservice.entities.Product;
import me.salahbkd.inventoryservice.services.ProductServiceImpl;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private ProductServiceImpl productService;
    StreamBridge streamBridge;
    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable Long productId) {
        var employee =  productService.findById(productId);

        if(employee == null)
            throw new RuntimeException("product not found with id: " + productId);

        return employee;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductDto productDto) {
        Product newProduct = new Product();
        newProduct.setDescription(productDto.getDescription());
        newProduct.setPrice(productDto.getPrice());
        newProduct.setQuantity(productDto.getQuantity());
        newProduct.setName(productDto.getName());

        final String topicName = "product_topic";
        productService.save(newProduct);
        streamBridge.send(topicName, newProduct);
        return newProduct;
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        var product = productService.findById(productId);

        if(product == null)
            throw new RuntimeException("product id not found " + productId);

        productService.deleteById(productId);

        return "deleted product with id" + productId;
    }
}
