package com.medtrack.medtrack.model.usuario.dto;

import com.medtrack.medtrack.model.usuario.CategoriaUsuario;

import java.time.LocalDate;

public record DadosUsuarioAtualizacao(
        String nome,
        String nomeUsuario,
        String numeroTelefone,
        String senha,
        CategoriaUsuario tipoConta,
        LocalDate dataNascimento
) {}

