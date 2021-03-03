package com.example.vote.pojo;

import javafx.scene.control.ChoiceBox;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
@Getter
@Setter
public class Vote {
    private int voteId;
    private int choiceId;
    private int userId;
    private String subject;
}
