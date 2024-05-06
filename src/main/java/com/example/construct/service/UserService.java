package com.example.construct.service;


import com.revise.shopee.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
 List<UserDto> getListUser();

 UserDto getUserById(String userId);
 List<UserDto> searchUser(String keyword);
}
