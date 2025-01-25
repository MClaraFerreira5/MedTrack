package com.medtrack.medtrack.model.usuario.dto;

import com.medtrack.medtrack.model.usuario.CategoriaUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadoUsuarioCadastro(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotNull
        LocalDate dataNascimento,

        @NotBlank
        String numeroTelefone,

        @NotBlank
        String nomeUsuario,

        @NotBlank
        String senha,

        @NotNull
        CategoriaUsuario categoria
) {
}
