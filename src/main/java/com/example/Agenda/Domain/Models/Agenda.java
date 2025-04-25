package com.example.Agenda.Domain.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "documento")
    @Size(max=14)
    public String documento;
    @Size(max=100)
    public String Nome;
    @JsonManagedReference
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<AgendaContatos> Contato = new ArrayList<>();
    @JsonManagedReference
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL, orphanRemoval = true)
    public Collection<AgendaEnderecos> Endereco  = new ArrayList<>();

    public Collection<AgendaContatos> getContatos() {
        return this.Contato;
    }

    public Collection<AgendaEnderecos> getEnderecos() {
        return this.Endereco;
    }

    public void setAgenda()
    {
        this.Contato.forEach(c -> c.setAgenda(this));
        this.Endereco.forEach(e -> e.setAgenda(this));
    }
}
