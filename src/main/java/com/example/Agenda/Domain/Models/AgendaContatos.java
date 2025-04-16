package com.example.Agenda.Domain.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

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

    @ManyToOne(optional = true)
    @JoinColumn(name = "agenda_id", nullable = true)
    @ToString.Exclude
    private Agenda agenda;
}
