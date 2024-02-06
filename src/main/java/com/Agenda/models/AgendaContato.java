package com.Agenda.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table
public class AgendaContato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Size(max=20)
    public String Celular;
    @Size(max=100)
    public String Email;
    @Size(max=20)
    public String Telefone;
}
