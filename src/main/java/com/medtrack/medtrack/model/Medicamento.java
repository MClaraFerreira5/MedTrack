package com.medtrack.medtrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Medicamentos")
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

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getDosagem() {
        return dosagem;
    }

    public void setDosagem(double dosagem) {
        this.dosagem = dosagem;
    }

    public String getFrequenciaUso() {
        return frequenciaUso;
    }

    public void setFrequenciaUso(String frequenciaUso) {
        this.frequenciaUso = frequenciaUso;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", principioAtivo='" + principioAtivo + '\'' +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", dosagem=" + dosagem +
                ", frequenciaUso='" + frequenciaUso + '\'' +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
