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

    //@NotNull
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GROUP_ID")
    public Group getGroup() {
        return group;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    public List<Cart> getCarts() {
        return carts;
    }

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "JOIN_ORDER_PRODUCT",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")}
    )
    public List<Order> getOrders() {
        return orders;
    }
}