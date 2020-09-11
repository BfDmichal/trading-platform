package com.BfDmichal.tradingplatform.service;

import com.BfDmichal.tradingplatform.controller.exception.UserNotFundException;
import com.BfDmichal.tradingplatform.domain.Advertisement;
import com.BfDmichal.tradingplatform.domain.User;
import com.BfDmichal.tradingplatform.domain.UserDetail;
import com.BfDmichal.tradingplatform.domain.dto.AdvertisementDto;
import com.BfDmichal.tradingplatform.mapper.AdvertisementMapper;
import com.BfDmichal.tradingplatform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  implements UserDetailsService{
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

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        return new UserDetail(userRepository.findByEmail(emailAddress));
    }
}
