package com.example.demo.point2point.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("point2point")
public class RabbitMQMsgSenderImpl implements RabbitMQMsgSender{

    @Value("${example.demo.rabbitmq.queue-name}")
    public String QUEUE_NAME;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(QUEUE_NAME, message);
    }
}
