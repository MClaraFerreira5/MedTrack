package com.medtrack.medtrack.model.medicamento.dto;

import com.medtrack.medtrack.model.medicamento.Medicamento;

import java.time.LocalTime;
import java.util.List;

public record DadosMedicamentoMobile(

        Long id,
        String nome,
        String principioAtivo,
        String dosagem,
        List<LocalTime> horarios
) {
    public DadosMedicamentoMobile(Medicamento medicamento) {
        this(medicamento.getId(), medicamento.getNome(),
                medicamento.getPrincipioAtivo(), medicamento.getDosagem(),null);
    }
}
