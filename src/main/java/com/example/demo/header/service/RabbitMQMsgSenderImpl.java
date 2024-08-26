package com.example.demo.header.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("header")
public class RabbitMQMsgSenderImpl implements RabbitMQMsgSender {

    @Value("${example.demo.header.exhchage}")
    public String EXCHANGE_NAME;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String messageText) {

        String [] routingKeys = {"error","info","debug"};

        int length = ((3*routingKeys.length)+3);
        for (int i=3; i<length;i++){

            int key = i%3;

            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setHeader("type", routingKeys[key]);
            MessageConverter messageConverter = new SimpleMessageConverter();
            Message message = messageConverter.toMessage(String.format(messageText+" : %s",routingKeys[key]), messageProperties);
            rabbitTemplate.convertAndSend(EXCHANGE_NAME, "", message);
        }

    }
}
