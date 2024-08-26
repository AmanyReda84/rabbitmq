package com.example.demo.point2point.controller;

import com.example.demo.point2point.service.RabbitMQMsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Profile("point2point")
@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private RabbitMQMsgSender rabbitMQMsgSender;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        rabbitMQMsgSender.sendMessage(message);
        return "Message sent: " + message;
    }
}
