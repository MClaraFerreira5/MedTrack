package com.medtrack.medtrack.model.usuario.dto;

import java.time.LocalDate;

public record DadosUsuarioAtualizacao(
        String nome,
        String nomeUsuario,
        String numeroTelefone,
        String senha,
        LocalDate dataNascimento
) {}

