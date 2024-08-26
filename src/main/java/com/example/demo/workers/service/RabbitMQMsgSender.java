package com.example.demo.workers.service;

public interface RabbitMQMsgSender {

    void sendMessage(String message);
}
