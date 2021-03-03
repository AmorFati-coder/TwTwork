package com.example.vote.service;

import com.example.vote.dao.UserMapper;
import com.example.vote.pojo.User;
import com.example.vote.utils.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public MessageData getAllUser() {
        try {
            return MessageData.createSuccessMsg(userMapper.getAllUser());
        }catch (Exception exception){
            return MessageData.createDefErrorMsg();
        }
    }
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    @Override
    public MessageData addUser(String userName, String passsword) {
        lock.lock();
        try {
            return MessageData.createSuccessMsg("添加成功",userMapper.addUser(userName,passsword));
        }catch (Exception exception){
            return MessageData.createDefErrorMsg();
        }finally {
            lock.unlock();
        }

    }
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    @Override
    public MessageData updateUser(String userName, String password) {
        lock.lock();
        try {
            return MessageData.createSuccessMsg("修改成功",userMapper.updateUser(userName,password));
        }catch (Exception exception) {
            return MessageData.createDefErrorMsg();
        }finally {
            lock.unlock();
        }
    }
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    @Override
    public MessageData deleteUser(int userId) {
        try {
            return MessageData.createSuccessMsg("删除成功",userMapper.deleteUser(userId));
        }catch (Exception exception){
            return MessageData.createDefErrorMsg();
        }
    }
}
