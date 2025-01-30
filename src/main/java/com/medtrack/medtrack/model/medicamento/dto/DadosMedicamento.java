package com.medtrack.medtrack.model.medicamento.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosMedicamento(

        @NotBlank
        String nome,

        @NotBlank
        String principioAtivo,

        int quantidadeEstoque,

        @Positive
        double dosagem,

        String observacoes,

        @NotNull
        Long usuarioId,

        Long dependenteId,

        @NotNull
        @Valid
        DadosFrequenciaUso frequenciaUso



) {

}
