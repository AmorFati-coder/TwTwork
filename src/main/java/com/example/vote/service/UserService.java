package com.example.vote.service;

import com.example.vote.utils.MessageData;

public interface UserService {
    public MessageData getAllUser();

    public MessageData addUser(String userName,String passsword);

    public MessageData updateUser(String userName,String password);

    public MessageData deleteUser(int userId);
}
