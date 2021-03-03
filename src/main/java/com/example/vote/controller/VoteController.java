package com.example.vote.controller;

import com.example.vote.dao.VoteMapper;
import com.example.vote.service.VoteService;
import com.example.vote.utils.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    VoteService voteService;
    @GetMapping("/allVote")
    public MessageData getAllVote(){
        return voteService.getAllVote();
    }
    @PostMapping("/vote")
    public MessageData addVote(@RequestParam("subject") String subject,
                               @RequestParam("userId") int userId){
        return MessageData.createSuccessMsg("添加成功",voteService.addVote(userId,subject));
    }

    @DeleteMapping("/vote")
    public MessageData deleteVote(@RequestParam("userId") int userId,
                                  @RequestParam("voteId") int voteId){
        return MessageData.createSuccessMsg(voteService.deleteVote(userId, voteId));
    }

}
