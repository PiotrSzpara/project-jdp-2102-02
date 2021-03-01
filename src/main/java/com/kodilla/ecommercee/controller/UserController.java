package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return new UserDto(userDto.getUserId(), "Giuseppe", "goodPeople@gmail.com","noH4ck@bbl3","1A2z3",true);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public void blockUser(@RequestParam int userId) {
        System.out.println("zmienna.getUserId.setStatus");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUserKey")
    public String createUserKey(@RequestParam String email, @RequestParam String password) {
        return "superTajnyToken";
    }
}


