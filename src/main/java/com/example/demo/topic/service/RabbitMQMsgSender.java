package com.example.demo.topic.service;

public interface RabbitMQMsgSender {

    void sendMessage(String message);
}
