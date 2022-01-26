package me.salahbkd.billingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data @NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private double price;
    private double quantity;
}
