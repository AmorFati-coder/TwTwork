package com.example.vote.service;

import com.example.vote.dao.VoteMapper;
import com.example.vote.pojo.Vote;
import com.example.vote.utils.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.locks.ReentrantLock;

@Service
public class VoteServiceImpl implements VoteService{
    private static ReentrantLock lock = new ReentrantLock();

    @Autowired
    VoteMapper voteMapper;
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    @Override
    public MessageData addVote(int userId,String subject) {
        lock.lock();
        try {
            return MessageData.createSuccessMsg("创建成功",voteMapper.addVote(userId,subject));
        }catch (Exception e){
            return MessageData.createDefErrorMsg();
        }finally {
            lock.unlock();
        }
    }
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    @Override
    public MessageData deleteVote(int userId, int voteId) {
        try {
            return MessageData.createSuccessMsg("删除成功",voteMapper.deleteVote(userId,voteId));
        }catch (Exception e){
            return MessageData.createDefErrorMsg();
        }
    }

    @Override
    public MessageData getAllVote() {
        try {
            return MessageData.createSuccessMsg("获取成功",voteMapper.getAllVote());
        }catch (Exception exception){
            return MessageData.createDefErrorMsg();
        }


}
}
