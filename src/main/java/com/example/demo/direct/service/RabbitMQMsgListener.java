package com.example.demo.direct.service;

public interface RabbitMQMsgListener {
    void receiveMessage1(String message);

    void receiveMessage2(String message);
}

