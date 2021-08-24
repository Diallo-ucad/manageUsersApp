package com.technicaltest.manageusersacountapp.service;

import com.technicaltest.manageusersacountapp.entity.User;
import com.technicaltest.manageusersacountapp.exception.ResourceNotFoundException;
import com.technicaltest.manageusersacountapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        Optional<User> userDb = this.userRepository.findById(id);
        if(userDb.isPresent()){
            return userDb.get();
        }else {
            throw new ResourceNotFoundException("User with id: " +id+" not found !");
        }
    }
}
