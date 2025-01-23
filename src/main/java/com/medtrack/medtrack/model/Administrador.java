package com.medtrack.medtrack.model;


import com.medtrack.medtrack.model.usuario.Usuario;

import java.time.LocalDate;

public class Administrador extends Usuario {
    public Administrador(String nome, String email, String nomeUsuario, String senha, Categoria tipoConta, LocalDate dataNascimento) {
        super(nome, email, nomeUsuario, senha, tipoConta, dataNascimento);
    }
}
