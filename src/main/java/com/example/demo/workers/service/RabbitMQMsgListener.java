package com.example.demo.workers.service;

public interface RabbitMQMsgListener {
    void receiveMessage(String message) throws InterruptedException;


}

