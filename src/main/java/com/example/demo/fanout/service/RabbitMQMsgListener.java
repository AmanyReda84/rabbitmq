package com.example.demo.fanout.service;

public interface RabbitMQMsgListener {
    void receiveMessage1(String message);

    void receiveMessage2(String message);
}

