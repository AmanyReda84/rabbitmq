package com.example.demo.fanout.controller;

import com.example.demo.fanout.service.RabbitMQMsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("fanout")
@RestController
@RequestMapping("/api")
public class DirectController {

    @Autowired
    private RabbitMQMsgSender rabbitMQMsgSender;

    @GetMapping("/send")
    public String sendMessage() {

        int messagesCount = 10;
        for (int i = 0; i<messagesCount;i++){
            rabbitMQMsgSender.sendMessage(String.format("fake body in message %d", i));
        }

        return String.format("%d Messages sent successfully ...",messagesCount);
    }
}
