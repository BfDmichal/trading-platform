package com.BfDmichal.tradingplatform.service;

import com.BfDmichal.tradingplatform.domain.User;
import com.BfDmichal.tradingplatform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(int userId){
        return userRepository.findById(userId);
    }
    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }
    public User saveUser(User user){
       return userRepository.save(user);
    }

}
