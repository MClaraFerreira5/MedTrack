package com.medtrack.medtrack.service.usuario;

import com.medtrack.medtrack.config.exception.AdministradorNaoEncontradoException;
import com.medtrack.medtrack.model.dependente.Dependente;
import com.medtrack.medtrack.model.dependente.dto.DadosDependente;
import com.medtrack.medtrack.model.dependente.dto.DadosDependentePut;

import com.medtrack.medtrack.repository.DependenteRepository;
import com.medtrack.medtrack.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {

    private final DependenteRepository dependenteRepository;
    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public DependenteService(DependenteRepository dependenteRepository, UsuarioRepository usuarioRepository, UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.dependenteRepository = dependenteRepository;
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Dependente cadastrar(DadosDependente dadosDependente) {
        if (usuarioRepository.existsByNomeUsuario(dadosDependente.nomeUsuario()) || dependenteRepository.existsByNomeUsuario(dadosDependente.nomeUsuario())) {
            throw new RuntimeException("Nome de usuário já está em uso!");
        }

        var usuario = usuarioService.buscarPorId(dadosDependente.administradorId());
        if(usuario.isPresent()) {
            var administrador = usuario.get();

            String senhaHashed = passwordEncoder.encode(dadosDependente.senha());

            // Cria o dependente com a senha criptografada
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

    public Dependente atualizar(DadosDependentePut dados) {
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
