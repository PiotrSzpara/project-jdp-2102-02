package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDao;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartDbService {

    private final CartDao cartDao;

    public Cart createCart(Cart cart){
        return cartDao.save(cart);
    }

    public Product getProductFromCart(int productId){
        return cartDao.findProductfromCart(productId);
    }

    public void addProductToCart(int productId){
        cartDao.addProductToCart(productId);
    }

    public void removeProductFromCart(int productId){
        cartDao.removeProductToCart(productId);
    }

    public Order createOrder(int orderId){
        return cartDao.createOrder(orderId);
    }

}
