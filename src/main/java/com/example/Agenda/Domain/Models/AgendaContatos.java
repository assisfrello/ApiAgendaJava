package com.example.Agenda.Domain.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class AgendaContatos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Size(max=20)
    public String Celular;
    @Size(max=100)
    public String Email;
    @Size(max=20)
    public String Telefone;

    @ManyToOne
    @JoinColumn(name = "agenda_id", nullable = false)
    private Agenda agenda;
}
