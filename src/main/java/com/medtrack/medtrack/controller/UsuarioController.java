package com.medtrack.medtrack.controller;

import com.medtrack.medtrack.model.usuario.Usuario;
import com.medtrack.medtrack.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class UsuarioController {

    private final UsuarioRepository repositorio;

    public UsuarioController(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }

    @PostMapping("/cadastre-se")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario) {
        System.out.println("Usuário recebido: " + usuario);
        // Salva o usuário no banco de dados
        try {
            repositorio.save(usuario);
            return ResponseEntity.ok("Usuário cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao cadastrar usuário");
        }
    }

}
