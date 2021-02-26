package com.kodilla.ecommercee;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;

    public Product() {
    }

    public Product(String productName, String productDescription, double productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public Product(int productId, String productName, String productDescription, double productPrice) {
        this.productId = productId;
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

    @NotNull
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

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
