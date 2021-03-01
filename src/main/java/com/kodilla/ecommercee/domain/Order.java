package com.kodilla.ecommercee.domain;

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
@Table(name = "ORDERS")
public class Order {
    private Long orderId;
    private String name;
    private boolean isPaid;
    private Cart cart = new Cart();
    private List<Product> products = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID", unique = true)
    public Long getOrderId() {
        return orderId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "IS_PAID")
    public boolean isPaid() {
        return isPaid;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    @JoinTable(
            name = "JOIN_ORDER_PRODUCT",
            joinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}
    )
    public List<Product> getProducts() {
        return products;
    }
}
