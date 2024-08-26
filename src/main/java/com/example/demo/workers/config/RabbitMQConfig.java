package com.example.demo.workers.config;


import com.example.demo.workers.service.RabbitMQMsgListener;
import com.example.demo.workers.service.RabbitMQMsgListenerImpl;
import com.example.demo.workers.service.RabbitMQMsgSender;
import com.example.demo.workers.service.RabbitMQMsgSenderImpl;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("workers")
public class RabbitMQConfig {

    @Value("${example.demo.rabbitmq.queue-name}")
    private String queueName;

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }


    @Bean
    public RabbitMQMsgListener listener1(){
        return new RabbitMQMsgListenerImpl();
    }

    @Bean
    public RabbitMQMsgListener listener2(){
        return new RabbitMQMsgListenerImpl();
    }


}
