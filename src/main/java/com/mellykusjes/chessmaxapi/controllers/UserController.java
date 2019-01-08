package com.mellykusjes.chessmaxapi.controllers;

import com.mellykusjes.chessmaxapi.interfaces.UserService;
import com.mellykusjes.chessmaxapi.models.User;
import com.mellykusjes.chessmaxapi.models.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/user/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User user(@PathVariable int id) {
        return userService.read(id);
    }

    @GetMapping(path = "/user/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User user(UserModel userModel) {
        User user = new User(userModel.getFirstName(), userModel.getLastName());
        userService.create(user);
        return user;
    }
}
