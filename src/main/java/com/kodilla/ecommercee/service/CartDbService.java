package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDao;
import com.kodilla.ecommercee.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartDbService {

    private final CartDao cartDao;

    public Cart createCart(int id){
        Cart cart = new Cart();
        cart.setCartId(id);
        return cartDao.save(cart);
    }

    public List<Product> getProductsFromCart(){
        return cartDao.getProducts();
    }

    public void addProductToCart(Product product){
        cartDao.addProduct(product);
    }

    public void removeProductFromCart(Product product){
        cartDao.deleteProduct(product);
    }

    public void createOrder(int orderId){
        cartDao.createNewOrder(orderId);
    }

}
