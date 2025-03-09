package com.medtrack.medtrack.controller;

import com.medtrack.medtrack.model.usuario.Usuario;
import com.medtrack.medtrack.model.usuario.dto.DadosLogin;
import com.medtrack.medtrack.repository.UsuarioRepository;
import com.medtrack.medtrack.service.jwt.JwtService;
import com.medtrack.medtrack.model.usuario.UsuarioDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody DadosLogin dados) {
        System.out.println("🔑 Tentativa de login: " + dados.username());
        System.out.println("🔐 Senha fornecida: " + dados.password());

        Usuario usuario = usuarioRepository.findByNomeUsuario(dados.username())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        System.out.println("🔐 Senha no banco: " + usuario.getSenhaHashed());

        // Autenticando o usuário
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dados.username(), dados.password())
            );

            if (authentication.isAuthenticated()) {
                UsuarioDetails usuarioDetails = new UsuarioDetails(usuario);
                String jwt = jwtService.generateToken(usuarioDetails);

                Map<String, String> response = new HashMap<>();
                response.put("token", jwt);
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            System.out.println("❌ Erro durante a autenticação: " + e.getMessage());
        }

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Falha na autenticação");
        return ResponseEntity.status(401).body(errorResponse);
    }
}
