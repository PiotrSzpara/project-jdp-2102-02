package com.kodilla.ecommercee.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuit {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;


   @Test
    public void testCreateNewCart() {
        //Given
        Cart cart = new Cart();

        //When
        cartDao.save(cart);

        //Then
        int id = cart.getCartId();
        Optional<Cart> readCart = cartDao.findById(id);
        assertTrue(readCart.isPresent());

        //CleanUp
        cartDao.deleteById(id);
    }

    @Test
    void testCartAndOrderRelations() {
       //Given
        Cart cart = new Cart();
        Order order = new Order();

        order.setOrderName("02/04/21");
        order.setCart(cart);
        cart.setOrder(order);

        //When
        cartDao.save(cart);
        int cartId = cart.getCartId();
        int cartIdInOrder = order.getCart().getCartId();

        long orderId = order.getOrderId();
        long orderIdInCart = cart.getOrder().getOrderId();

        //Then
        Assertions.assertSame(cartId, cartIdInOrder);
        Assertions.assertSame(orderId, orderIdInCart);

        //CleanUp
        cartDao.deleteById(cartId);


    }
    @Test
    void testCartAndUserRelations() {
       //Given
       List<Cart> carts = new ArrayList<>();

       Cart cart1 = new Cart();
       carts.add(cart1);

       User user = new User();

       user.setUserName("Adam");
       user.setEmail("adam@gmail.com");
       user.setCarts(carts);

       cart1.setUser(user);

       //When
       cartDao.save(cart1);
       int cart1Id = cart1.getCartId();

       int userId = user.getUserId();
       int cart1UserId = cart1.getUser().getUserId();

       //Then
       Assertions.assertSame(cart1UserId, userId);

       //CleanUp
       cartDao.deleteById(cart1Id);

   }
}
