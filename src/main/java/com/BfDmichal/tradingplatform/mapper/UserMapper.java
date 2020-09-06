package com.BfDmichal.tradingplatform.mapper;

import com.BfDmichal.tradingplatform.domain.User;
import com.BfDmichal.tradingplatform.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto){
        return new User(userDto.getId(),userDto.getEmail(),userDto.getPassword(),userDto.getPhone());
    }
    public UserDto mapToUserDto(final User user){
        return new UserDto(user.getId(),user.getEmail(),user.getPassword(),user.getPhone());
    }
    public List<UserDto> mapToUserDtoList(final List<User> userList){
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

}
