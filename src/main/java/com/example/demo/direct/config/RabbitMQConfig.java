package com.example.demo.direct.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("direct")
public class RabbitMQConfig {

    @Bean
    public Queue autoDeleteQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue2() {
        return new AnonymousQueue();
    }

    @Bean
    public DirectExchange direct(@Value("${example.demo.direct.exhchage}") String exchangeName) {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding1(DirectExchange direct,
                            Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(direct).with("error");
    }

    @Bean
    public Binding binding2(DirectExchange direct,
                            Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(direct).with("info");
    }

    @Bean
    public Binding binding3(DirectExchange direct,
                            Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(direct).with("debug");
    }

}
