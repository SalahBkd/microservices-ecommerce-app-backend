package me.salahbkd.inventoryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductEvent {
    private Long id;
    private String name;
    private String description;
    private double price;
    private double quantity;
}
