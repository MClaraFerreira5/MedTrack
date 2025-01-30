package com.medtrack.medtrack.service.usuario;

import com.medtrack.medtrack.model.usuario.Usuario;
import com.medtrack.medtrack.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    final
    UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repository.getUsuariosById();
    }
}
