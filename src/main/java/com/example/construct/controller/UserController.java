package com.example.construct.controller;

import com.example.construct.model.User;
import com.example.construct.model.dto.UserDto;
import com.example.construct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService1;

    @Autowired
    public UserController(UserService userService) {
        userService1=userService;
    }

    @GetMapping(value = {"/",""})
    public ResponseEntity<List<UserDto>> getAllUser()
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService1.getListUser());
    }

    @GetMapping("/detail")
    public ResponseEntity<UserDto> getUserById(@RequestParam(value = "id") String id)
    {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService1.getUserById(id));
        }
        catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @GetMapping("search/{nameKeyword}")
    public ResponseEntity<List<UserDto>> searchUserByNameKeyword(@PathVariable String nameKeyword)
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService1.searchUser(nameKeyword));
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> createUser()
    {
        return ResponseEntity.status(HttpStatus.OK).body(new User());
    }

    @DeleteMapping("/")
    public ResponseEntity<User> deleteUser()
    {
        return ResponseEntity.status(HttpStatus.OK).body(new User());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser()
    {
        return ResponseEntity.status(HttpStatus.OK).body(new User());
    }
}
