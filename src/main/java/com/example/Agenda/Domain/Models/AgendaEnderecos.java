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
public class AgendaEnderecos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Size(max=200)
    public String Logradouro;
    @Size(max=5)
    public String Numero;
    @Size(max=200)
    public String Complemento;
    @Size(max=100)
    public String Bairro;
    @Size(max=100)
    public String Cidade;
    @Size(max=2)
    public String Uf;

    @ManyToOne(optional = true)
    @JoinColumn(name = "agenda_id", nullable = true)
    @ToString.Exclude
    private Agenda agenda;
}
