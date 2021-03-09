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

    public Cart createCart(int id){
        Cart cart = new Cart();
        cart.setCartId(id);
        return cartDao.save(cart);
    }

    public Product getProductFromCart(Product product){
        return cartDao.findProductfromCart(product.getProductId());
    }

    public void addProductToCart(Product product){
        cartDao.addProductToCart(product);
    }

    public void removeProductFromCart(Product product){
        cartDao.removeProductToCart(product);
    }

    public Order createOrder(int orderId){
        return cartDao.createOrder(orderId);
    }

}
