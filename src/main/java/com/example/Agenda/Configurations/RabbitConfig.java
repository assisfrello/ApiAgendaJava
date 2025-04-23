package com.example.Agenda.Configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String AgendaAddQueue = "agendaQueue";

    @Bean
    public Queue queue() {
        return new Queue(AgendaAddQueue, false);
    }

    @Bean
    public RabbitTemplate RabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }
}
