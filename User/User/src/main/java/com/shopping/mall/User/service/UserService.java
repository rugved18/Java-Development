package com.shopping.mall.User.service;

import com.shopping.mall.User.model.User;
import com.shopping.mall.User.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User saveOrUpdateUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepo.findById(id);
    }

    public User updateUser(int id, User user) {
        if (!userRepo.existsById(id)) {
            return null; // Or throw an exception
        }
        user.setId(id);
        return userRepo.save(user);
    }

    public void deleteUserById(int id) {
        userRepo.deleteById(id);
    }
}
