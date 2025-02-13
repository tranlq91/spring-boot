package com.example.learn.spring.service;

import com.example.learn.spring.entity.User;
import com.example.learn.spring.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    /**
     * @return
     */
    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    /**
     * @param user
     */
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    /**
     * @param id
     */
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public String introduceUser(int id) {
        System.out.println("Executing getUser method...");
        return "User with ID: " + id;
    }

    /**
     * @param user
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void saveUserFailed(User user) throws Exception {
        userRepository.save(user);
        if (user.getName().equals("ERROR2")) {
            throw new Exception("Test Rollback");
        }
    }
}
