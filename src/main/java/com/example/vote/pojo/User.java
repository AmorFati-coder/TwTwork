package com.example.vote.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class User {
    private int userId;
    private String userName;
    private String password;
}
