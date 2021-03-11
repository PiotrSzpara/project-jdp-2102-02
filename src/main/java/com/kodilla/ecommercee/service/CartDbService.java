package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartDbService {

    private final CartDao cartDao;
    private final OrderDao orderDao;

    public Cart createCart(int id){
        Cart cart = new Cart();
        cart.setCartId(id);
        return cartDao.save(cart);
    }

    public List<Product> getProductsFromCart(Cart cart){
        List<Product> products = cart.getProducts();
        return products;
    }

    public void addProductToCart(Cart cart, Product product){
        List<Product> products = cart.getProducts();
        products.add(product);
        cart.setProducts(products);
        cartDao.save(cart);
    }

    public void deleteProductFromCart(Cart cart, Product product){
        List<Product> products = cart.getProducts();
        products.remove(product);
        cart.setProducts(products);
        cartDao.save(cart);
    }

    public void createOrder(Cart cart){
        Order order = new Order();
        order.setCart(cart);
        orderDao.save(order);
    }

}
