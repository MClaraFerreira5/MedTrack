package com.medtrack.medtrack.repository;

import com.medtrack.medtrack.model.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findAll(Pageable paginacao);

    Optional<Usuario> getUsuariosById(Long id);

    Optional<Usuario> findByNomeUsuario(String nomeUsuario);

}
