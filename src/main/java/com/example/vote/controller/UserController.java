package com.example.vote.controller;

import com.example.vote.service.UserService;
import com.example.vote.utils.MessageData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/allUser")
    public MessageData getAllUser(){
        return userService.getAllUser();
    }

    @PutMapping("/user")
    public MessageData updateUser(@RequestParam("userName") String userName,
                                  @RequestParam("score") String password){
        return userService.updateUser(userName,password);
    }

    @DeleteMapping("/user")
    public MessageData deleteUser(@RequestParam("userId") int userId){
        return userService.deleteUser(userId);
    }

    @PostMapping("/user")
    public MessageData addUser(@RequestParam("userName") String userName,
                               @RequestParam("password") String password){
        return userService.addUser(userName, password);
    }
}
