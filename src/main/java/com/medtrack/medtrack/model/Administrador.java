package com.medtrack.medtrack.model;


public class Administrador extends Usuario{
    public Administrador(String nome, String email, String nomeUsuario, String senha, Categoria tipoConta, String dataNascimento) {
        super(nome, email, nomeUsuario, senha, tipoConta, dataNascimento);
    }
}
