package com.medtrack.medtrack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;

    @Enumerated(EnumType.STRING)
    @JsonProperty("tipoConta")
    private Categoria tipoConta;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("email")
    private String email;

    @JsonProperty("senha")
    private String senhaHashed;

    @JsonProperty("dataNascimento")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column (unique = true)
    @JsonProperty("nomeUsuario")
    private String nomeUsuario;

    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Medicamento> medicamentos = new ArrayList<>();

    public Usuario() {}

    public Usuario(String nome, String email, String nomeUsuario, String senha, Categoria tipoConta, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        this.senhaHashed = hashSenha(senha);
        this.tipoConta = tipoConta;
        this.dataNascimento = dataNascimento;

    }

    private static String hashSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(Integer.toHexString(0xFF & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao hash a senha", e);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = LocalDate.parse(dataNascimento);
    }

    public Categoria getTipoConta() {
        return tipoConta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senhaHashed;
    }

    public void setTipoConta(Categoria tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void setSenha(String senha) {
        this.senhaHashed = hashSenha(senha);
    }

    public void atualizarSenha(String novaSenha) {
        this.senhaHashed = hashSenha(novaSenha);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email + ", Nome de usuário: " + nomeUsuario;
    }
}





