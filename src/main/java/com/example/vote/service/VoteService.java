package com.example.vote.service;

import com.example.vote.utils.MessageData;

public interface VoteService {
    public MessageData getAllVote();

    public MessageData addVote(int userId,String subject);

    public MessageData deleteVote(int userId,int voteId);
}
