package com.medtrack.medtrack.controller;

import com.medtrack.medtrack.config.exception.TratadorDeErros;
import com.medtrack.medtrack.model.medicamento.Medicamento;
import com.medtrack.medtrack.model.medicamento.dto.DadosMedicamento;
import com.medtrack.medtrack.repository.MedicamentoRepository;
import com.medtrack.medtrack.service.medicamento.MedicamentoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {
    private final MedicamentoRepository repositorio;
    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoRepository repositorio, MedicamentoService medicamentoService) {
        this.repositorio = repositorio;
        this.medicamentoService = medicamentoService;
    }

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity<Medicamento> create(@RequestBody @Valid DadosMedicamento dadosMedicamento) {
        System.out.println(dadosMedicamento);
        Medicamento medicamento = medicamentoService.criarMedicamento(dadosMedicamento);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(medicamento.getId())
                .toUri();


        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Medicamento>> all() {
        List<Medicamento> medicamentos = repositorio.findAll();
        return ResponseEntity.ok(medicamentos);
    }


    //achar medicamento específico
    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> detalharMedicamento(@PathVariable Long id) {
        Medicamento medicamento = repositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Medicamento não encontrado"));

        return ResponseEntity.ok(medicamento);
    }


    @PutMapping("alterar/{id}")
    @Transactional
    public ResponseEntity<Medicamento> atualizarMedicamento(@RequestBody Medicamento novoMedicamento, @PathVariable Long id) {
        Medicamento medicamentoAtualizado = repositorio.findById(id)
                .map(medicamento -> {
                    medicamento.setNome(novoMedicamento.getNome());
                    medicamento.setObservacoes(novoMedicamento.getObservacoes());
                    medicamento.setPrincipioAtivo(novoMedicamento.getPrincipioAtivo());
                    medicamento.setDosagem(novoMedicamento.getDosagem());
                    medicamento.setFrequenciaUso(novoMedicamento.getFrequenciaUso());
                    medicamento.setQuantidadeEstoque(novoMedicamento.getQuantidadeEstoque());
                    return repositorio.save(medicamento);
                })
                .orElseGet(() -> {
                    novoMedicamento.setId(id);
                    return repositorio.save(novoMedicamento);
                });

        return ResponseEntity.ok(medicamentoAtualizado);
    }


    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<Void> deletarMedicamento(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            throw new EntityNotFoundException("Medicamento não encontrado para exclusão");
        }

        repositorio.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna HTTP 204 (No Content)
    }
}










