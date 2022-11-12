package com.springboot.jwt.Spring_Boot_JWT_MongoDB.controller;

import com.springboot.jwt.Spring_Boot_JWT_MongoDB.model.User;
import com.springboot.jwt.Spring_Boot_JWT_MongoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public String savingUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getUserDetails/{userId}")
    public User getUserDetails(@PathVariable("userId") ObjectId userId) {
        //ObjectId userId = (ObjectId) httpServletRequest.getAttribute("userId");
        return userService.getUser(userId);
    }
}
