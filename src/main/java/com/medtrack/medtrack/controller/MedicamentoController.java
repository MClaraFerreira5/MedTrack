package com.medtrack.medtrack.controller;

import com.medtrack.medtrack.model.medicamento.Medicamento;
import com.medtrack.medtrack.model.medicamento.dto.DadosMedicamento;
import com.medtrack.medtrack.repository.MedicamentoRepository;
import com.medtrack.medtrack.service.medicamento.MedicamentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {
    private final MedicamentoRepository repositorio;
    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoRepository repositorio, MedicamentoService medicamentoService) {
        this.repositorio = repositorio;
        this.medicamentoService = medicamentoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Medicamento> create(@RequestBody @Valid DadosMedicamento dadosMedicamento) {
        Medicamento medicamento = medicamentoService.criarMedicamento(dadosMedicamento);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(medicamento.getId())
                .toUri();


        return ResponseEntity.created(uri).body(medicamento);
    }
}








