package com.medtrack.medtrack.model.medicamento.dto;

import com.medtrack.medtrack.model.medicamento.FrequenciaUsoTipo;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record DadosFrequenciaUso(
        Long id,

        @NotNull
        FrequenciaUsoTipo frequenciaUsoTipo,

        @NotBlank
        List<String> diasSemana,

        List<LocalTime> horariosEspecificos,

        Integer intervaloHoras,

        LocalTime primeiroHorario,

        @Future
        LocalDate dataInicio,

        @Future
        LocalDate dataTermino
) {
}


