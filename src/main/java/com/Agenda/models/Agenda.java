package com.Agenda.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Size(max=14)
    public String Documento;
    @Size(max=100)
    public String Nome;
    @JoinColumn(name = "id_contato")
    @OneToOne
    public AgendaContato Contato;
    @JoinColumn(name = "id_endereco")
    @OneToOne
    public AgendaEndereco Endereco;
}
