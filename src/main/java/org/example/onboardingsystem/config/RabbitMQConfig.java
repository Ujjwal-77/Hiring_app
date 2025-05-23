package org.example.onboardingsystem.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue jobOfferQueue() {
        return new Queue("jobOfferQueue", true);
    }
}