package com.medtrack.medtrack.service.usuario;

import com.medtrack.medtrack.model.usuario.Usuario;
import com.medtrack.medtrack.model.usuario.dto.DadosUsuarioCadastro;
import com.medtrack.medtrack.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

//    final
//    UsuarioRepository repository;
    private UsuarioRepository repositorio;

    public UsuarioService(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }
    private PasswordEncoder passwordEncoder;
    @Transactional
    public Usuario cadastrarUsuario(DadosUsuarioCadastro dados) {
        if (repositorio.existsByNomeUsuario(dados.nomeUsuario())) {
            throw new RuntimeException("Nome de usuário já está em uso!");
        }

        var usuario = new Usuario(dados);
        usuario.setSenhaHashed(passwordEncoder.encode(dados.senha()));

        return repositorio.save(usuario);
    }
    public Optional<Usuario> buscarPorId(Long id) {
        return repositorio.getUsuariosById(id);
    }
}
