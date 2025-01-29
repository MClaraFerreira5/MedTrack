package com.medtrack.medtrack.service.medicamento;

import com.medtrack.medtrack.model.medicamento.FrequenciaUso;
import com.medtrack.medtrack.model.medicamento.Medicamento;
import com.medtrack.medtrack.model.medicamento.dto.DadosMedicamento;
import com.medtrack.medtrack.model.usuario.Usuario;
import com.medtrack.medtrack.repository.DependenteRepository;
import com.medtrack.medtrack.repository.FrequenciaUsoRepository;
import com.medtrack.medtrack.repository.MedicamentoRepository;
import com.medtrack.medtrack.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    private final UsuarioRepository usuarioRepository;

    private final DependenteRepository dependenteRepository;

    private final FrequenciaUsoRepository frequenciaUsoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository, UsuarioRepository usuarioRepository,
                              DependenteRepository dependenteRepository, FrequenciaUsoRepository frequenciaUsoRepository) {
        this.medicamentoRepository = medicamentoRepository;
        this.usuarioRepository = usuarioRepository;
        this.dependenteRepository = dependenteRepository;
        this.frequenciaUsoRepository = frequenciaUsoRepository;
    }


    public Medicamento criarMedicamento(DadosMedicamento dadosMedicamento) {
        Medicamento medicamento;
        // Associa o medicamento ao usuário
        Usuario usuario = usuarioRepository.findById(dadosMedicamento.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));


        // Caso tenha sido informado o dependenteId, o usuário é um administrador
        if (dadosMedicamento.dependenteId() != null) {
            var dependente = dependenteRepository.findById(dadosMedicamento.dependenteId())
                    .orElseThrow(() -> new IllegalArgumentException("Dependente não encontrado"));

        }

        // Criando o medicamento
        FrequenciaUso frequenciaUso;
        if (dadosMedicamento.frequenciaUso().id() != null) {
            frequenciaUso = frequenciaUsoRepository.findById(dadosMedicamento.frequenciaUso().id())
                    .orElseThrow(() -> new IllegalArgumentException("Frequência de uso não encontrada"));
        } else {
            frequenciaUso = new FrequenciaUso(dadosMedicamento.frequenciaUso());
            frequenciaUso = frequenciaUsoRepository.save(frequenciaUso);
        }


        medicamento = new Medicamento(dadosMedicamento, usuario, dependente);
        medicamento.setFrequenciaUso(frequenciaUso);

        // Salvando e retornando o medicamento
        return medicamentoRepository.save(medicamento);
    }
}
