package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table
public class Cart {
    private int cartId;
    private List<Product> products = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ID", unique = true)
    public int getCartId() {
        return cartId;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    public List<Product> getProducts() {
        return products;
    }
}
