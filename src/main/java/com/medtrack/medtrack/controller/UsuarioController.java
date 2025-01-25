package com.medtrack.medtrack.controller;

import com.medtrack.medtrack.model.usuario.Usuario;
import com.medtrack.medtrack.model.usuario.dto.DadoUsuarioCadastro;
import com.medtrack.medtrack.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioRepository repositorio;

    public UsuarioController(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadoUsuarioCadastro dados) {
        var usuario = new Usuario(dados);
        repositorio.save(usuario);

        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();

        return ResponseEntity.created(uri).body(usuario);
    }

}
