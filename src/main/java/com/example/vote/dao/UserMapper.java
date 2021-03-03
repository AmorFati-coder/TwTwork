package com.example.vote.dao;

import com.example.vote.pojo.User;
import com.example.vote.utils.MessageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface UserMapper{
    public List<User> getAllUser();

    public int addUser(String userName,String passsword);

    public int updateUser(String userName,String password);

    public int deleteUser(int userId);

}
