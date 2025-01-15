package com.medtrack.medtrack.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DadosUsuario {

    private String tipoConta;
    private String nome;
    private String email;
    private String nomeUsuario;
    private String senhaHashed;
    private String dataNascimento;

    public DadosUsuario(String nome, String email, String nomeUsuario, String senha, String tipoConta, String dataNascimento) {
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

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getTipoConta() {
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

    public String getSenhaHashed() {
        return senhaHashed;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void atualizarSenha(String novaSenha) {
        this.senhaHashed = hashSenha(novaSenha);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email + ", Nome de usuário: " + nomeUsuario;
    }
}



