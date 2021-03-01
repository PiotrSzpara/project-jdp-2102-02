package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "carts")
public class Cart {

    @Id
    @GeneratedValue
    private int cartId;

    @ManyToMany
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    private User user = new User();

    @OneToOne
    private Order order = new Order();

    public int getCartId() {
        return cartId;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "cartId", referencedColumnName = "Cart_cartId")},
                    inverseJoinColumns = {@JoinColumn(name = "productId", referencedColumnName = "Product_productId")}
            )
    public List<Product> getProducts() {
        return products;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    @OneToOne
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
