package com.example.demo.workers.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Profile("workers")
public class RabbitMQMsgSenderImpl implements RabbitMQMsgSender {

    @Value("${example.demo.rabbitmq.queue-name}")
    public String queueName;


    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMessage(String message) {

        for(int i=0;i<20;i++){
            rabbitTemplate.convertAndSend(queueName, String.format("fake message - %d", new Random().nextInt(0, 1000)));
            System.out.println ("Message sent");
        }

    }
}
