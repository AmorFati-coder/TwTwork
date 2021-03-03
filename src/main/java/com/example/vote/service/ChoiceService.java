package com.example.vote.service;

import com.example.vote.utils.MessageData;

public interface ChoiceService {
    public MessageData getAllChoice();

    public MessageData addChoice(int voteId,String text);
}
