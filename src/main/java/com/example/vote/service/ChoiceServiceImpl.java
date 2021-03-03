package com.example.vote.service;

import com.example.vote.dao.VoteMapper;
import com.example.vote.pojo.Vote;
import com.example.vote.utils.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class ChoiceServiceImpl implements ChoiceService{
    private static ReentrantLock lock = new ReentrantLock();
    @Autowired
    ChoiceService choiceService;

    @Override
    public MessageData getAllChoice() {
        try {
            return MessageData.createSuccessMsg(choiceService.getAllChoice());
        }catch (Exception e){
            return MessageData.createDefErrorMsg();
        }
    }
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    @Override
    public MessageData addChoice(int voteId, String text) {
        lock.lock();
        try {
            return MessageData.createSuccessMsg(choiceService.addChoice(voteId, text));
        }catch (Exception exception){
            return MessageData.createDefErrorMsg();
        }finally {
            lock.unlock();
        }
    }
}
