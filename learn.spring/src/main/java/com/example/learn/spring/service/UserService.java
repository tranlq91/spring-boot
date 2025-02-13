package com.example.learn.spring.service;

import com.example.learn.spring.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();

    void saveUser(User user);

    void deleteUser(Long id);

    Optional<User> findUserById(Long id);

    String introduceUser(int id);

    void saveUserFailed(User user) throws Exception;
}
