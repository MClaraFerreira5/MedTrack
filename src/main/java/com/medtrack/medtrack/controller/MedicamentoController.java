package com.medtrack.medtrack.controller;

import com.medtrack.medtrack.model.medicamento.Medicamento;
import com.medtrack.medtrack.model.medicamento.dto.DadosMedicamento;
import com.medtrack.medtrack.repository.MedicamentoRepository;
import com.medtrack.medtrack.service.medicamento.MedicamentoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {
    private static final Logger logger = LoggerFactory.getLogger(MedicamentoController.class);
    private final MedicamentoRepository repositorio;
    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoRepository repositorio, MedicamentoService medicamentoService) {
        this.repositorio = repositorio;
        this.medicamentoService = medicamentoService;
    }

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity<Medicamento> create(@RequestBody @Valid DadosMedicamento dadosMedicamento) {
        logger.info("Recebendo requisição para criar medicamento: {}", dadosMedicamento);
        Medicamento medicamento = medicamentoService.criarMedicamento(dadosMedicamento);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(medicamento.getId())
                .toUri();

        System.out.println(dadosMedicamento);

        return ResponseEntity.created(uri).body(medicamento);
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<Medicamento>> all(Pageable pageable) {
        Page<Medicamento> medicamentos = repositorio.findAll(pageable);
        return ResponseEntity.ok(medicamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> detalharMedicamento(@PathVariable Long id) {
        Medicamento medicamento = repositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Medicamento não encontrado"));
        return ResponseEntity.ok(medicamento);
    }

    @PutMapping("/alterar/{id}")
    @Transactional
    public ResponseEntity<Medicamento> atualizarMedicamento(@RequestBody @Valid DadosMedicamento dadosMedicamento, @PathVariable Long id) {
        return repositorio.findById(id).map(medicamento -> {
            Medicamento medicamentoAtualizado = medicamentoService.atualizarMedicamento(dadosMedicamento, medicamento);
            Medicamento atualizado = repositorio.save(medicamentoAtualizado);
            return ResponseEntity.ok(atualizado);
        }).orElseThrow(() -> new EntityNotFoundException("Medicamento não encontrado para atualização"));
    }


    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<Void> deletarMedicamento(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            throw new EntityNotFoundException("Medicamento não encontrado para exclusão");
        }
        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
