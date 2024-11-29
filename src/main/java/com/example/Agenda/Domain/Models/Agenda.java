package com.example.Agenda.Domain.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Size(max=14)
    public String Documento;
    @Size(max=100)
    public String Nome;
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<AgendaContatos> Contato = new ArrayList<>();;
    @Getter
    @Setter
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL, orphanRemoval = true)
    public Collection<AgendaEnderecos> Endereco  = new ArrayList<>();;

    public Collection<AgendaContatos> getContatos()
    {
        return Contato;
    }
}
