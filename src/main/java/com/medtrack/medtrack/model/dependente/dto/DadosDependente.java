package com.medtrack.medtrack.model.dependente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DadosDependente (

    @NotBlank
    String nome,

    @NotBlank
    @Email
    String email,

    @NotBlank
    String telefone,

    Long administradorId,

    @NotBlank
    String nomeUsuario,

    @NotBlank
    String senha
)
  {
      public DadosDependente withAdministradorId(Long administradorId) {
          return new DadosDependente(
                  this.nome,
                  this.email,
                  this.telefone,
                  administradorId,
                  this.nomeUsuario,
                  this.senha
          );
      }
  }
