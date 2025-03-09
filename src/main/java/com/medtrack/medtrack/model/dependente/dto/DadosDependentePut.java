package com.medtrack.medtrack.model.dependente.dto;

import com.medtrack.medtrack.model.dependente.Dependente;

public record DadosDependentePut (
        Long id,
        String nome,
        String email,
        String telefone,
        Long administradorId
) {
    public DadosDependentePut(Dependente dependente) {
        this(dependente.getId(), dependente.getNome(), dependente.getEmail(), dependente.getTelefone(), dependente.getAdministrador().getId());
    }
}
