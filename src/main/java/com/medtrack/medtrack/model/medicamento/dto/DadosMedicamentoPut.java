package com.medtrack.medtrack.model.medicamento.dto;

import jakarta.validation.constraints.NotNull;

public record DadosMedicamentoPut(
        @NotNull
        Long id,

        @NotNull
        Long usuarioId,

        String nome,

        String principioAtivo,

        double dosagem,

        String observacoes,

        DadosFrequenciaPut dadosFrequenciaPut
        ) {




}
