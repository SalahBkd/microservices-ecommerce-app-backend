package me.salahbkd.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.salahbkd.billingservice.entity.ProductGetRequest;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class  BuyProductsDto {
    private String customerName;
    private List<ProductGetRequest> customerProducts;
}
