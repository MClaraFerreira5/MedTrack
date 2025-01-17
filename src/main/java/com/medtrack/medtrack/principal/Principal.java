package com.medtrack.medtrack.principal;

import com.medtrack.medtrack.model.Usuario;
import com.medtrack.medtrack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Principal {
    private UsuarioRepository repositorio;

    @Autowired // A anotação @Autowired permite que o Spring injete a dependência automaticamente
    public Principal(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void salvarUsuario(Usuario usuario) {
        repositorio.save(usuario);
    }
}
