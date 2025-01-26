package com.medtrack.medtrack.model.medicamento;

import com.medtrack.medtrack.model.medicamento.dto.DadosFrequenciaUso;
import com.medtrack.medtrack.service.conversor.ConverteDados;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class FrequenciaUso {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private FrequenciaUsoTipo frequenciaUsoTipo;

    @ElementCollection
    private List<String> diasSemana;
    private boolean usoContinuo;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = ConverteDados.class)
    private List<LocalTime> horariosEspecificos = null;
    private int intervaloHoras = 0;
    private LocalTime primeiroHorario = null;
    private LocalDate dataInicio = null;
    private LocalDate dataTermino = null;

    public FrequenciaUso(@Valid DadosFrequenciaUso dados) {
        this.frequenciaUsoTipo = dados.frequenciaUsoTipo();
        this.diasSemana = dados.diasSemana();
        this.horariosEspecificos = dados.horariosEspecificos();
        this.intervaloHoras = dados.intervaloHoras();
        this.primeiroHorario = dados.primeiroHorario();
        this.dataInicio = dados.dataInicio();
        this.dataTermino = dados.dataTermino();
    }

}
