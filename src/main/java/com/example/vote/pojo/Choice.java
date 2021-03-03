package com.example.vote.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Choice {
    private int choiceId;
    private String text;
    private int count;
}
