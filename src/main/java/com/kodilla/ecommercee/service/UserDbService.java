package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserDbService {

    private final UserDao userDao;

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public void deleteUserByUserName(String userName) {
        userDao.deleteUserByUserName(userName);
    }

    public void blockUserByUserId(int userId) {
        User user = new User();
        user.setStatus(false);
    }

    public String saveTokenUserKey(String email) {
        User user = new User();
        Random random = new Random();
        String tokenUserKey = String.valueOf(random.nextInt(99999999)) ;
        user.setTokenUserKey(tokenUserKey);
        return tokenUserKey;
    }
}

