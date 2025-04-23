package com.example.Agenda.Controller;

import com.example.Agenda.Configurations.RabbitConfig;
import com.example.Agenda.Domain.Models.Agenda;
import org.springframework.stereotype.Controller;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Controller
public class AgendaReceiveController {
    @RabbitListener(queues = RabbitConfig.AgendaAddQueue)
    public void AddReceiveMessage(String agenda) {
        System.out.println("Mensagem recebida do RabbitMQ no AgendaReceiveController: " + agenda);
    }
}
