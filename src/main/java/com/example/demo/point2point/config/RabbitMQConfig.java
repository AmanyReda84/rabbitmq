package com.example.demo.point2point.config;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("point2point")
public class RabbitMQConfig {

    @Bean
    public Queue queue(@Value("${example.demo.rabbitmq.queue-name}") String queueName) {
        return new Queue(queueName, false);
    }
}
