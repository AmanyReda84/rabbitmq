package com.example.demo.workers.controller;

import com.example.demo.workers.service.RabbitMQMsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("workers")
@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private RabbitMQMsgSender rabbitMQMsgSender;

    @GetMapping("/send")
    public String sendMessage() {
            rabbitMQMsgSender.sendMessage("fake body in message ");
        return "Messages sent successfully ...";
    }
}
