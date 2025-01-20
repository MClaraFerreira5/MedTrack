package com.medtrack.medtrack.repository;

import com.medtrack.medtrack.model.Medicamento;
import com.medtrack.medtrack.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
