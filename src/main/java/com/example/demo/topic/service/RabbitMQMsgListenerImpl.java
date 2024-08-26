package com.example.demo.topic.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("topic")
public class RabbitMQMsgListenerImpl implements RabbitMQMsgListener {


    @Override
    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receiveMessage1(String message) {

        System.out.println("Message Received - Listener 1: "+ message);

    }

    @Override
    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receiveMessage2(String message) {

        System.out.println("Message Received - Listener 2: "+ message);

    }


}
