package com.medtrack.medtrack.controller.mobile;

import com.medtrack.medtrack.model.dependente.Dependente;
import com.medtrack.medtrack.model.dependente.DependenteDetails;
import com.medtrack.medtrack.model.usuario.Usuario;
import com.medtrack.medtrack.model.usuario.UsuarioDetails;
import com.medtrack.medtrack.model.usuario.dto.DadosLogin;
import com.medtrack.medtrack.repository.DependenteRepository;
import com.medtrack.medtrack.repository.UsuarioRepository;
import com.medtrack.medtrack.service.jwt.JwtService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth/mobile")
public class AuthMobileController {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final DependenteRepository dependenteRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthMobileController(UsuarioRepository usuarioRepository,
                                JwtService jwtService, DependenteRepository dependenteRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.dependenteRepository = dependenteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody DadosLogin dados) {
        System.out.println("🔑 Tentativa de login: " + dados.username());
        System.out.println("🔐 Senha fornecida: " + dados.password());

        // Verificando se o nome de usuário existe em Usuários ou Dependentes
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNomeUsuario(dados.username());
        Optional<Dependente> dependenteOpt = dependenteRepository.findByNomeUsuario(dados.username());

        if (usuarioOpt.isPresent()) {
            // Se for um Usuário
            Usuario usuario = usuarioOpt.get();
            if (!passwordEncoder.matches(dados.password(), usuario.getSenhaHashed())) {
                return ResponseEntity.status(401).body(Collections.singletonMap("error", "Senha inválida"));
            }
            // Criar um token JWT para o Usuário
            UsuarioDetails usuarioDetails = new UsuarioDetails(usuario);
            String jwt = jwtService.generateToken(usuarioDetails);

            Map<String, String> response = new HashMap<>();
            response.put("token", jwt);
            return ResponseEntity.ok(response);
        } else if (dependenteOpt.isPresent()) {
            // Se for um Dependente
            Dependente dependente = dependenteOpt.get();
            if (!passwordEncoder.matches(dados.password(), dependente.getSenhaHashed())) {
                return ResponseEntity.status(401).body(Collections.singletonMap("error", "Senha inválida"));
            }
            // Criar um token JWT para o Dependente
            DependenteDetails dependenteDetails = new DependenteDetails(dependente);
            String jwt = jwtService.generateTokenDependente(dependenteDetails);

            Map<String, String> response = new HashMap<>();
            response.put("token", jwt);
            return ResponseEntity.ok(response);
        }

        // Se o nome de usuário não existir
        return ResponseEntity.status(401).body(Collections.singletonMap("error", "Usuário ou dependente não encontrado"));
    }


}
