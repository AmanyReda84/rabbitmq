package com.example.demo.point2point.service;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("point2point")
public class RabbitMQMsgListenerImpl implements RabbitMQMsgListener{


    @Override
    @RabbitListener(queues = "#{queue.getName}")
    public void receiveMessage(String message) {

        System.out.println("Message Received: "+ message);

    }
}
