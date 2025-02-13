package com.example.learn.spring.controller;

import com.example.learn.spring.entity.User;
import com.example.learn.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/rest/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void saveUser(@RequestBody User user) throws Exception {
        userService.saveUserFailed(user);
    }
}
