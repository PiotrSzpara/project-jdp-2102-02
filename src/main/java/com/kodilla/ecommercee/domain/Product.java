package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {

    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private Group group;
    private List<Cart> carts = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public Product(String productName, String productDescription, double productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID", unique = true)
    public int getProductId() {
        return productId;
    }

    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    @Column(name = "PRODUCT_DESCRIPTION")
    public String getProductDescription() {
        return productDescription;
    }

    @Column(name = "PRODUCT_PRICE")
    public double getProductPrice() {
        return productPrice;
    }

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    public Group getGroup() {
        return group;
    }

    @ManyToMany(mappedBy = "products")
    public List<Cart> getCarts() {
        return carts;
    }

    @ManyToMany
    @JoinTable(
            name = "JOIN_ORDER_PRODUCT",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")})
    public List<Order> getOrders() {
        return orders;
    }
}