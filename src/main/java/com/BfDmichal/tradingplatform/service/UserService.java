package com.BfDmichal.tradingplatform.service;

import com.BfDmichal.tradingplatform.controller.exception.UserNotFundException;
import com.BfDmichal.tradingplatform.domain.Advertisement;
import com.BfDmichal.tradingplatform.domain.User;
import com.BfDmichal.tradingplatform.domain.dto.AdvertisementDto;
import com.BfDmichal.tradingplatform.mapper.AdvertisementMapper;
import com.BfDmichal.tradingplatform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
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
    public List<Advertisement> getMyAdvertisements(int userId) throws UserNotFundException{
        User user = userRepository.findById(userId).orElseThrow(UserNotFundException::new);
        return user.getAdvertisementList();
    }
}
