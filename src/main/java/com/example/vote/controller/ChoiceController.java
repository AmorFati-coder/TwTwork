package com.example.vote.controller;

import com.example.vote.service.ChoiceService;
import com.example.vote.utils.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;

@RestController
@RequestMapping("/choice")
public class ChoiceController {
    @Autowired
    ChoiceService choiceService;

    @GetMapping("/allChoice")
    public MessageData getAllChoice(){
        return choiceService.getAllChoice();
    }

    @PostMapping("/choice")
    public MessageData addChoice(@RequestParam("voteId") int voteId,
                                 @RequestParam("text") String text){
        return choiceService.addChoice(voteId, text);
    }

}
