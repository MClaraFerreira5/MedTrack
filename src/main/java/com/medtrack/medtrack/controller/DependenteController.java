package com.medtrack.medtrack.controller;

import com.medtrack.medtrack.model.usuario.Dependente;
import com.medtrack.medtrack.model.usuario.dto.DadosDependente;
import com.medtrack.medtrack.service.usuario.DependenteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/dependentes")
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    @Transactional
    @PostMapping("/cadastrar")
    public ResponseEntity<Dependente> cadastrar(@RequestBody DadosDependente dadosDependente) {
        Dependente dependente = dependenteService.cadastrar(dadosDependente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dependente.getId())
                .toUri();

        return ResponseEntity.created(uri).body(dependente);
    }

    @GetMapping("/home")
    public ResponseEntity<List<Dependente>> listarTodos() {
        List<Dependente> dependentes = dependenteService.listarTodos();
        return ResponseEntity.ok(dependentes);
    }

    @GetMapping("/{administradorId}")
    public ResponseEntity<List<Dependente>> listarPorAdministrador(@PathVariable Long administradorId) {
        List<Dependente> dependentes = dependenteService.listarPorAdministradorId(administradorId);
        return ResponseEntity.ok(dependentes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dependente> buscarPorId(@PathVariable Long id) {
        Dependente dependente = dependenteService.buscarPorId(id);
        if (dependente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dependente);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Dependente> atualizar(@PathVariable Long id, @RequestBody DadosDependente dadosDependente) {
        Dependente dependenteAtualizado = dependenteService.atualizar(id, dadosDependente);
        if (dependenteAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dependenteAtualizado);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!dependenteService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        dependenteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}

