package com.medtrack.medtrack.model.usuario;

import com.medtrack.medtrack.model.usuario.dto.DadosDependente;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Dependentes")
@Getter
@NoArgsConstructor
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "administrador_id", nullable = false)
    private Usuario administrador;

    public Dependente(@Valid DadosDependente dados, Usuario administrador) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.administrador = administrador;
    }

    public Dependente(DadosDependente dadosDependente) {
    }
}
