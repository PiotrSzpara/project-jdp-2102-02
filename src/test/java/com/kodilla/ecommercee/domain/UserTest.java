package com.kodilla.ecommercee.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

        User user = User.builder()
                .userName("John")
                .email("john.doe@test.com")
                .password("John1234")
                .tokenUserKey("token1")
                .build();

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

        User user = User.builder()
                .userName("John")
                .password("John123")
                .email("john.doe@test.com")
                .build();
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
}