package me.salahbkd.billingservice.entity;

import lombok.Data;

@Data
public class ProductGetRequest {
    private String productName;
    private double quantity;
}
