package com.kodilla.ecommercee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return new UserDto(userDto.getUserId(), "Giuseppe", "goodPeople@gmail.com","noH4ck@bbl3",123,true);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public void blockUser(@RequestParam int userId) {
        System.out.println("zmienna.getUserId.setStatus");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUserKey")
    public void createUserKey(@RequestParam String username, @RequestParam String password) {
        System.out.println("user.setSecretUserKey");
    }
}


