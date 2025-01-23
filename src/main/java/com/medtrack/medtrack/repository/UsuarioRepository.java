package com.medtrack.medtrack.repository;

import com.medtrack.medtrack.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
