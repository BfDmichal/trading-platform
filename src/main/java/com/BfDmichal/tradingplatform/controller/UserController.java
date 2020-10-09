package com.BfDmichal.tradingplatform.controller;

import com.BfDmichal.tradingplatform.exception.UserNotFundException;
import com.BfDmichal.tradingplatform.domain.dto.AdvertisementDto;
import com.BfDmichal.tradingplatform.domain.dto.UserDto;
import com.BfDmichal.tradingplatform.mapper.AdvertisementMapper;
import com.BfDmichal.tradingplatform.service.UserService;
import com.BfDmichal.tradingplatform.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdvertisementMapper advertisementMapper;
    @Autowired
    private UserService dbService;

    @RequestMapping(method = RequestMethod.GET, value = "/getUsers")
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(dbService.getUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUser")
    public UserDto getUser(@RequestParam int userId) throws UserNotFundException {
        return userMapper.mapToUserDto(dbService.getUserById(userId).orElseThrow(UserNotFundException::new));
    }
    @RequestMapping(method = RequestMethod.GET,value = "/getUserAdvertisements")
    public List<AdvertisementDto> getListOfUserAdvertisements(@RequestParam int id) throws UserNotFundException{
        return advertisementMapper.mapToAdvertisementDtoList(dbService.getMyAdvertisements(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser")
    public void deleteUser(@RequestParam int userId) {
        dbService.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(dbService.saveUser(userMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        dbService.saveUser(userMapper.mapToUser(userDto));
    }
}
