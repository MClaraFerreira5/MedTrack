package com.medtrack.medtrack.repository;

import com.medtrack.medtrack.model.usuario.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DependenteRepository extends JpaRepository<Dependente, Long> {
    List<Dependente> findByAdministradorId(long administradorId);
}

