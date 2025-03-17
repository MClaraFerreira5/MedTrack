package com.medtrack.medtrack.model.medicamento.dto;

import com.medtrack.medtrack.model.medicamento.Medicamento;

import java.time.LocalTime;
import java.util.List;

public record DadosMedicamentoMobile(

        Long id,
        String nome,
        String compostoAtivo,
        String dosagem,
        List<LocalTime> horarios,
        boolean usoContinuo
) {
    public DadosMedicamentoMobile(Medicamento medicamento, List<LocalTime> horarios, boolean usoContinuo) {
        this(medicamento.getId(), medicamento.getNome(),
                medicamento.getPrincipioAtivo(), medicamento.getDosagem(), horarios, usoContinuo);
    }
}
