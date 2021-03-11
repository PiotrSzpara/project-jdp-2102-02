package com.kodilla.ecommercee.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class UserTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CartDao cartDao;

    @Test
    public void testAddNewUser() {

        User user = new User();

        user.setUserName("John");
        user.setPassword("John123");
        user.setEmail("john.doe@test.com");

        userDao.save(user);
        int id = user.getUserId();

        assertNotEquals(0, id);

        userDao.deleteById(id);
    }

    @Test
    public void testUserAndCartRelations() {

        List<Cart> carts = new ArrayList<>();
        Cart cart = new Cart();
        Cart cart2 = new Cart();
        carts.add(cart);
        carts.add(cart2);

        User user = new User();

        user.setUserName("John");
        user.setPassword("John123");
        user.setEmail("john.doe@test.com");

        cart.setUser(user);
        cart2.setUser(user);
        user.setCarts(carts);

        userDao.save(user);
        cartDao.save(cart);
        cartDao.save(cart2);

        int userId = user.getUserId();
        int cartUserId = cart.getUser().getUserId();
        int cart2UserId = cart2.getUser().getUserId();
        int cartId = cart.getCartId();
        int cart2Id = cart2.getCartId();


        assertEquals(cartUserId, userId);
        assertEquals(cart2UserId, userId);

        cartDao.deleteById(cartId);
        cartDao.deleteById(cart2Id);
        userDao.deleteById(userId);
    }

    @Test
    public void testRemoveUser() {
        User user = new User();

        user.setUserName("John");
        user.setPassword("John123");
        user.setEmail("john.doe@test.com");

        userDao.save(user);

        int userId = user.getUserId();
        userDao.deleteById(userId);

        assertFalse(userDao.existsById(userId));
    }

//    @Test
//    public void testRelationsAfterDeletingUser() {
//        User user = new User();
//
//        user.setUserName("John");
//        user.setPassword("John123");
//        user.setEmail("john.doe@test.com");
//
//        Cart cart = new Cart();
//        List<Cart> carts = new ArrayList<>();
//
//        carts.add(cart);
//
//        user.setCarts(carts);
//        cart.setUser(user);
//
//        userDao.save(user);
//        cartDao.save(cart);
//
//        userDao.deleteById(user.getUserId());
//
//        Cart checkCart = cartDao.findById(cart.getCartId());
//
//        assertNotEquals(checkCart.getCartId(), cart.getCartId());

//    }
}