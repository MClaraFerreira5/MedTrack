package com.medtrack.medtrack.service.usuario;

import com.medtrack.medtrack.config.exception.AdministradorNaoEncontradoException;
import com.medtrack.medtrack.model.dependente.Dependente;
import com.medtrack.medtrack.model.dependente.dto.DadosDependente;
import com.medtrack.medtrack.model.dependente.dto.DadosUpdateDependente;
import com.medtrack.medtrack.repository.DependenteRepository;
import com.medtrack.medtrack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {

    private final DependenteRepository dependenteRepository;
    private final UsuarioService usuarioService;

    public DependenteService(DependenteRepository dependenteRepository, UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.dependenteRepository = dependenteRepository;
        this.usuarioService = usuarioService;
    }

    public Dependente cadastrar(DadosDependente dadosDependente) {
        var usuario = usuarioService.buscarPorId(dadosDependente.administradorId());
        if(usuario.isPresent()) {
            var administrador = usuario.get();
            return dependenteRepository.save(new Dependente(dadosDependente, administrador));

        } else {
            throw new AdministradorNaoEncontradoException("Administrador não encontrado com o ID: " + dadosDependente.administradorId());
        }
    }

    public List<Dependente> listarTodos() {
        return dependenteRepository.findAll();
    }

    public List<Dependente> listarPorAdministradorId(Long administradorId) {
        return dependenteRepository.findByAdministradorId(administradorId);
    }

    public Optional<Dependente> buscarPorId(Long id) {
        return dependenteRepository.findById(id);
    }

    public Dependente atualizar(DadosUpdateDependente dados) {
        var dependente = dependenteRepository.getReferenceById(dados.id());
        dependente.atualizarInformacoes(dados);

        return dependente;
        
    }

    public void deletar(Long id) {
        dependenteRepository.deleteById(id);
    }

    public boolean existePorId(Long id) {
        return dependenteRepository.existsById(id);
    }
}
