package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARTS")
public class Cart {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ID")
    private int cartId;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private User user = new User();

    @OneToOne(cascade = CascadeType.ALL)
    private Order order = new Order();

    public int getCartId() {
        return cartId;
    }


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "Cart_cartId")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "Product_productId")}
    )
    public List<Product> getProducts() {
        return products;
    }

    @ManyToOne//(cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    @OneToOne//(cascade = CascadeType.ALL)
    public Order getOrder() {
        return order;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return cartId == cart.cartId && products.equals(cart.products) && user.equals(cart.user) && order.equals(cart.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, products, user, order);
    }
}