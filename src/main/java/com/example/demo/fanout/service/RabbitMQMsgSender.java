package com.example.demo.fanout.service;

public interface RabbitMQMsgSender {

    void sendMessage(String message);
}
