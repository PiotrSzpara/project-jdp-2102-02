package com.kodilla.ecommercee.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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

    }
}