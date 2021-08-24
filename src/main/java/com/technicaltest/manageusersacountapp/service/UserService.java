package com.technicaltest.manageusersacountapp.service;

import com.technicaltest.manageusersacountapp.entity.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public List<User> getAllUsers();
    public User getUserById(int id);

}
