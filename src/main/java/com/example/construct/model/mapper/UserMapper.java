package com.example.construct.model.mapper;


import com.example.construct.model.User;
import com.example.construct.model.dto.UserDto;

public class UserMapper {
    public static UserDto userToUserDto(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setAvatar(user.getAvatar());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
