package com.BfDmichal.tradingplatform.controller;

import com.BfDmichal.tradingplatform.domain.dto.UserDto;
import com.BfDmichal.tradingplatform.exception.UserNotFundException;
import com.BfDmichal.tradingplatform.mapper.UserMapper;
import com.BfDmichal.tradingplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class ForgetPasswordController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.PUT, value = "/forgetPassword")
    public UserDto forgotPassword(@RequestParam String email) throws UserNotFundException {
        return userMapper.mapToUserDto(userService.changePasswordAndSendMailToUser(email));
    }
}
