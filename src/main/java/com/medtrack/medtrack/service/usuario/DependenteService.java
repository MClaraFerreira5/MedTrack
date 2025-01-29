package com.medtrack.medtrack.service.usuario;

import com.medtrack.medtrack.model.usuario.Dependente;
import com.medtrack.medtrack.model.usuario.dto.DadosDependente;
import com.medtrack.medtrack.repository.DependenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    public Dependente cadastrar(DadosDependente dadosDependente) {
        return dependenteRepository.save(new Dependente(dadosDependente));
    }

    public List<Dependente> listarTodos() {
        return dependenteRepository.findAll();
    }

    public List<Dependente> listarPorAdministradorId(Long administradorId) {
        return dependenteRepository.findByAdministradorId(administradorId);
    }

    public Dependente buscarPorId(Long id) {
        return dependenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Dependente não encontrado."));
    }

    public Dependente atualizar(Long id, DadosDependente dadosDependente) {
        Dependente dependente = buscarPorId(id);
        dependente = new Dependente(dadosDependente);
        return dependenteRepository.save(dependente);
    }

    public void deletar(Long id) {
        dependenteRepository.deleteById(id);
    }

    public boolean existePorId(Long id) {
        return dependenteRepository.existsById(id);
    }
}
