package com.example.vote.dao;

import com.example.vote.pojo.Choice;
import com.example.vote.pojo.User;
import com.example.vote.utils.MessageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.security.MessageDigest;
import java.util.List;

@Repository
@Mapper
public interface ChoiceMapper{
    public List<Choice> getChoice();

    public int addChoice(int voteId,String text);


}
