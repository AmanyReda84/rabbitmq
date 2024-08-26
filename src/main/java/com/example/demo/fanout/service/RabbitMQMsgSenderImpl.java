package com.example.demo.fanout.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("fanout")
public class RabbitMQMsgSenderImpl implements RabbitMQMsgSender {

    @Value("${example.demo.fanout.exhchage}")
    public String EXCHANGE_NAME;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME,"", message);
    }
}
