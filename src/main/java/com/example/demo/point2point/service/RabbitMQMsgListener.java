package com.example.demo.point2point.service;

public interface RabbitMQMsgListener {
    void receiveMessage(String message);
}

