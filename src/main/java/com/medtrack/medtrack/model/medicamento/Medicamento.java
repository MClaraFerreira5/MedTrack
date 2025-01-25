package com.medtrack.medtrack.model.medicamento;

import com.medtrack.medtrack.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Medicamentos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera valores automaticamente no banco
    private Long id;

    private String nome;
    private String principioAtivo;
    private int quantidadeEstoque;
    private double dosagem;
    private String frequenciaUso;
    private String observacoes;

    @ManyToOne
    private Usuario usuario;

    public Medicamento(Long id, int quantidadeEstoque, String nome, String principioAtivo,
                       double dosagem, String frequenciaUso, String observacoes) {
        this.id = id;
        this.quantidadeEstoque = quantidadeEstoque;
        this.nome = nome;
        this.principioAtivo = principioAtivo;
        this.dosagem = dosagem;
        this.frequenciaUso = frequenciaUso;
        this.observacoes = observacoes;
    }

}
