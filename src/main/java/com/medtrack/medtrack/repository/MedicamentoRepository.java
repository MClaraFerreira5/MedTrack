package com.medtrack.medtrack.repository;

import com.medtrack.medtrack.model.medicamento.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    Medicamento getMedicamentoById(long id);
}
