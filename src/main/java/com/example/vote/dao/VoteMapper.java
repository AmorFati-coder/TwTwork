package com.example.vote.dao;

import com.example.vote.pojo.Choice;
import com.example.vote.pojo.User;
import com.example.vote.pojo.Vote;
import com.example.vote.utils.MessageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.security.MessageDigest;
import java.util.List;

@Repository
@Mapper
public interface VoteMapper{
    public List<Vote> getAllVote();

    public int addVote(int userId,String subject);

    public int deleteVote(int userId,int voteId);

}
