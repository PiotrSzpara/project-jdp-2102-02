package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {
    private int orderId;
    private String orderName;
    private boolean isPaid;
    private Date orderDate;
    private Cart cart;
    private List<Product> products = new ArrayList<>();

    public Order(int orderId, String orderName, boolean isPaid, Date orderDate) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.isPaid = isPaid;
        this.orderDate = orderDate;
    }


    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID", unique = true)
    public int getOrderId() {
        return orderId;
    }

    @Column(name = "ORDER_NAME")
    public String getOrderName() {
        return orderName;
    }

    @Column(name = "IS_PAID")
    public boolean isPaid() {
        return isPaid;
    }

    @Column(name = "ORDER_DATE")
    public Date getOrderDate() {
        return orderDate;
    }

    @OneToOne
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }


    @ManyToMany(mappedBy = "orders")
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return isPaid == order.isPaid &&
                Objects.equals(orderId, order.orderId) &&
                Objects.equals(orderName, order.orderName) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(cart, order.cart) &&
                Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderName, isPaid, orderDate, cart, products);
    }
}

