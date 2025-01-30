package com.medtrack.medtrack.controller;

import com.medtrack.medtrack.model.dependente.Dependente;
import com.medtrack.medtrack.model.dependente.dto.DadosDependente;
import com.medtrack.medtrack.model.dependente.dto.DadosUpdateDependente;
import com.medtrack.medtrack.service.usuario.DependenteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/dependentes")
public class DependenteController {

    private final DependenteService dependenteService;

    public DependenteController(DependenteService dependenteService) {
        this.dependenteService = dependenteService;
    }

    @Transactional
    @PostMapping("/cadastrar")
    public ResponseEntity<Dependente> cadastrar(@RequestBody DadosDependente dadosDependente) {
        var dependente = dependenteService.cadastrar(dadosDependente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dependente.getId())
                .toUri();

        return ResponseEntity.created(uri).body(dependente);
    }

    @GetMapping
    public ResponseEntity<List<Dependente>> listarTodos() {
        List<Dependente> dependentes = dependenteService.listarTodos();
        return ResponseEntity.ok(dependentes);
    }

    @GetMapping("/administrador/{id}")
    public ResponseEntity<List<Dependente>> listarPorAdministrador(@PathVariable Long administradorId) {
        List<Dependente> dependentes = dependenteService.listarPorAdministradorId(administradorId);
        return dependentes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(dependentes);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Dependente> detalharDependente(@PathVariable Long id) {
        return dependenteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());

    }

    @Transactional
    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosUpdateDependente dados) {
        var dependente = dependenteService.atualizar(dados);

        return ResponseEntity.ok(dependente);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        if (!dependenteService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        dependenteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}

