package com.kodilla.ecommercee.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuit {

    @Autowired
    CartDao cartDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;


   @Test
    public void testCreateNewCart() {
        //Given
        Cart cart = new Cart();

        //When
        cartDao.save(cart);

        //Then
        int id = cart.getCartId();
        Optional<Cart> readCart = cartDao.findById(id);
        Assert.assertTrue(readCart.isPresent());

        //CleanUp
        cartDao.deleteAll();
    }
}
