package com.medtrack.medtrack.model.dependente.dto;

import com.medtrack.medtrack.model.dependente.Dependente;
import jakarta.validation.constraints.NotNull;

public record DadosDependentePut (
        @NotNull
        Long id,
        String nome,
        String telefone,
        String email,
        @NotNull
        String nomeUsuario,
        @NotNull
        String senhaHashed
) {
    public DadosDependentePut(Dependente dependente) {
        this(dependente.getId(), dependente.getNome(), dependente.getTelefone(), dependente.getEmail(), dependente.getNomeUsuario(),
                dependente.getSenhaHashed());
    }
}
