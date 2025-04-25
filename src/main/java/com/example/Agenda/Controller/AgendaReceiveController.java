package com.example.Agenda.Controller;

import com.example.Agenda.Configurations.RabbitConfig;
import com.example.Agenda.Domain.Models.Agenda;
import com.example.Agenda.Service.IAgendaReceiveService;
import org.springframework.stereotype.Controller;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Controller
public class AgendaReceiveController {
    private final IAgendaReceiveService service;

    public AgendaReceiveController(IAgendaReceiveService service) {
        this.service = service;
    }

    @RabbitListener(queues = RabbitConfig.AgendaAddQueue)
    public void AddReceiveMessage(Agenda agenda) {
        service.Add(agenda);
    }
}
