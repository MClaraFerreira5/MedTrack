package com.medtrack.medtrack.model.medicamento;

import com.medtrack.medtrack.model.medicamento.dto.DadosMedicamento;
import com.medtrack.medtrack.model.dependente.Dependente;
import com.medtrack.medtrack.model.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "Medicamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String principioAtivo;
    private int quantidadeEstoque;
    private double dosagem;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "dependente_id")
    private Dependente dependente;

    @OneToOne
    @JoinColumn(name = "frequencia_uso_id")
    @NotNull
    @Valid FrequenciaUso frequenciaUso;


    public Medicamento(@Valid DadosMedicamento dadosMedicamento, Usuario usuario) {
        nome = dadosMedicamento.nome();
        principioAtivo = dadosMedicamento.principioAtivo();
        quantidadeEstoque = dadosMedicamento.quantidadeEstoque();
        dosagem = dadosMedicamento.dosagem();
        observacoes = dadosMedicamento.observacoes();
        this.usuario = usuario;
        var dadosFrequenciaUso = dadosMedicamento.frequenciaUso();
        this.frequenciaUso = new FrequenciaUso(dadosFrequenciaUso);
    }

    public Medicamento(@Valid DadosMedicamento dadosMedicamento, Dependente dependente) {
        nome = dadosMedicamento.nome();
        principioAtivo = dadosMedicamento.principioAtivo();
        quantidadeEstoque = dadosMedicamento.quantidadeEstoque();
        dosagem = dadosMedicamento.dosagem();
        observacoes = dadosMedicamento.observacoes();
        var dadosFrequenciaUso = dadosMedicamento.frequenciaUso();
        this.frequenciaUso = new FrequenciaUso(dadosFrequenciaUso);
        this.dependente = dependente;
    }


    public Medicamento(DadosMedicamento dadosMedicamento, Usuario usuario, Dependente dependente) {
    }
}
