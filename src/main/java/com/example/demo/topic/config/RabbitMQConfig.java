package com.example.demo.topic.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("topic")
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
    public TopicExchange topic(@Value("${example.demo.topic.exhchage}") String exchangeName) {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding binding1(TopicExchange topic,
                            Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(topic).with("#.error");
    }

    @Bean
    public Binding binding2(TopicExchange topic,
                            Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(topic).with("*.info");
    }

    @Bean
    public Binding binding3(TopicExchange topic,
                            Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(topic).with("debug.*");
    }

}
