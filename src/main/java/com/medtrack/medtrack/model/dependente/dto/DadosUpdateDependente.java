package com.medtrack.medtrack.model.dependente.dto;

import jakarta.validation.constraints.NotNull;

public record DadosUpdateDependente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        String email
) {
}
