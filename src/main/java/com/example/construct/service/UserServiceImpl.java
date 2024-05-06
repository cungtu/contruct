package com.example.construct.service;

import com.revise.shopee.model.User;
import com.revise.shopee.model.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.revise.shopee.model.mapper.UserMapper.userToUserDto;


@Component
public class UserServiceImpl implements UserService {
    private static List<User> userList= new ArrayList<>();

    static
    {
        userList.add(new User(1,"ab","","",""));

        userList.add(new User(2,"a","","",""));

        userList.add(new User(3,"","","",""));

        userList.add(new User(4,"","","",""));

    }


    @Override
    public List<UserDto> getListUser() {
        List<UserDto> userDtos = new ArrayList<UserDto>();
        for (User user : userList) {
            userDtos.add(userToUserDto(user));
        }
        return userDtos;
    }

    @Override
    public UserDto getUserById(String userId) {
        for (User user : userList) {
            if (user.getId()==Integer.parseInt(userId))
                return  userToUserDto(user);
        }
        throw new NullPointerException("User not found");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> userDtos = new ArrayList<UserDto>();
        for (User user : userList) {
            if (user.getName().contains(keyword))
                  userDtos.add(userToUserDto(user));
        }
        return userDtos;
    }
}
