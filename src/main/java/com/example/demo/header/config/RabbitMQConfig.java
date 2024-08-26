package com.example.demo.header.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("header")
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
    public HeadersExchange topic(@Value("${example.demo.header.exhchage}") String exchangeName) {
        return new HeadersExchange(exchangeName);
    }

    @Bean
    public Binding binding1(HeadersExchange exchange,
                            Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(exchange).where("type").matches("error");
    }

    @Bean
    public Binding binding2(HeadersExchange exchange,
                            Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(exchange).where("type").matches("info");
    }

    @Bean
    public Binding binding3(HeadersExchange exchange,
                            Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(exchange).where("type").matches("debug");
    }

}
