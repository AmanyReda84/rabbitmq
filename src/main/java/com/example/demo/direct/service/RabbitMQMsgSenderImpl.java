package com.example.demo.direct.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("direct")
public class RabbitMQMsgSenderImpl implements RabbitMQMsgSender {

    @Value("${example.demo.direct.exhchage}")
    public String EXCHANGE_NAME;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {

        String [] routingKeys = {"error","info","debug"};

        int length = ((3*routingKeys.length)+3);
        for (int i=3; i<length;i++){

            int key = i%3;
            rabbitTemplate.convertAndSend(EXCHANGE_NAME,routingKeys[key], String.format(message+" : %s",routingKeys[key]));
        }

    }
}
