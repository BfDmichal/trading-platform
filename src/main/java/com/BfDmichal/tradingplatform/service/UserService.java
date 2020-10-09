package com.BfDmichal.tradingplatform.service;

import com.BfDmichal.tradingplatform.exception.UserNotFundException;
import com.BfDmichal.tradingplatform.domain.Advertisement;
import com.BfDmichal.tradingplatform.domain.Mail;
import com.BfDmichal.tradingplatform.domain.User;
import com.BfDmichal.tradingplatform.domain.UserDetail;
import com.BfDmichal.tradingplatform.repositories.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
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
    @Autowired
    private MailService mailService;

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
    public User changePasswordAndSendMailToUser(String email) throws UserNotFundException {
        try {
            User user = userRepository.findByEmail(email);
            String newPassword = passwordGenerator();
            user = new User(user.getId(),user.getEmail(),newPassword,user.getPhone(),user.getRole());
            userRepository.save(user);
            mailService.send(new Mail(email,"Password Reset","Your new password is: "+newPassword));
            return user;
        }catch(Exception e){
            throw new UserNotFundException("User has not found in database.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        return new UserDetail(userRepository.findByEmail(emailAddress));
    }
    private String passwordGenerator(){
        return RandomStringUtils.randomAlphabetic(8);
    }
}
