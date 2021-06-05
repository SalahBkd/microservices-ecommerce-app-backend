package me.salahbkd.billingservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.salahbkd.billingservice.model.Product;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double quantity;
    private double price;
    private long productId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // TO PREVENT THE LOOP
    @ManyToOne
    private Bill bill;
    @Transient
    private Product product;
}
