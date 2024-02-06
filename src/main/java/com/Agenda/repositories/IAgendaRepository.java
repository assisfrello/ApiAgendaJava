package com.Agenda.repositories;

import com.Agenda.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgendaRepository extends JpaRepository<Agenda, Integer> {

}
