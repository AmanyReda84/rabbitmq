package com.example.demo.workers.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Random;


@Profile("workers")
@RabbitListener(queues = "#{queue.name}")
public class RabbitMQMsgListenerImpl implements RabbitMQMsgListener {

    private final int listenerNo;

    @Autowired
    public RabbitMQMsgListenerImpl (){
        this.listenerNo = new Random().nextInt();
    }


    @Override
    @RabbitHandler
    public void receiveMessage(String message) throws InterruptedException {
        System.out.printf("[%s] Message Received - Listener %d %n",message,listenerNo );
        Thread.sleep(60000);

        System.out.printf("Exiting Listener %d %n", listenerNo);

    }


}
