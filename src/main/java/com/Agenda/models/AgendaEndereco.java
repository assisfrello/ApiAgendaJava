package com.Agenda.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table
public class AgendaEndereco {
    @Id
    @GeneratedValue
    @Column(name = "id")
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
}
