package com.example.Agenda.Repository;

import com.example.Agenda.Domain.Models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAgendaRepository extends JpaRepository <Agenda, Long> {

}
