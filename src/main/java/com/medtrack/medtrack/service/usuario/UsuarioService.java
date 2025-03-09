package com.medtrack.medtrack.service.usuario;

import com.medtrack.medtrack.model.usuario.Usuario;
import com.medtrack.medtrack.model.usuario.dto.DadosUsuarioAtualizacao;
import com.medtrack.medtrack.model.usuario.dto.DadosUsuarioCadastro;
import com.medtrack.medtrack.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repositorio;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repositorio, PasswordEncoder passwordEncoder) {
        this.repositorio = repositorio;
        this.passwordEncoder = passwordEncoder;
    }

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

    @Transactional
    public Usuario atualizarUsuario(Long id, DadosUsuarioAtualizacao dados) {
        Usuario usuario = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        if (dados.nomeUsuario() != null && !dados.nomeUsuario().equals(usuario.getNomeUsuario()) &&
                repositorio.existsByNomeUsuario(dados.nomeUsuario())) {
            throw new RuntimeException("Nome de usuário já está em uso!");
        }

        if (dados.nome() != null) {
            usuario.setNome(dados.nome());
        }
        if (dados.nomeUsuario() != null) {
            usuario.setNomeUsuario(dados.nomeUsuario());
        }
        if (dados.numeroTelefone() != null) {
            usuario.setNumeroTelefone(dados.numeroTelefone());
        }
        if (dados.senha() != null) {
            usuario.setSenhaHashed(passwordEncoder.encode(dados.senha()));
        }
        if (dados.dataNascimento() != null) {
            usuario.setDataNascimento(dados.dataNascimento());
        }

        return repositorio.save(usuario);
    }
}
