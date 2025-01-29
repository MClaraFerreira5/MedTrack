package com.medtrack.medtrack.service.medicamento;

import com.medtrack.medtrack.model.medicamento.FrequenciaUso;
import com.medtrack.medtrack.model.medicamento.Medicamento;
import com.medtrack.medtrack.model.medicamento.dto.DadosMedicamento;
import com.medtrack.medtrack.model.usuario.Dependente;
import com.medtrack.medtrack.model.usuario.Usuario;
import com.medtrack.medtrack.repository.DependenteRepository;
import com.medtrack.medtrack.repository.FrequenciaUsoRepository;
import com.medtrack.medtrack.repository.MedicamentoRepository;
import com.medtrack.medtrack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private FrequenciaUsoRepository frequenciaUsoRepository;


    public Medicamento criarMedicamento(DadosMedicamento dadosMedicamento) {
        // Buscando o usuário e dependente, se necessário
        Usuario usuario = usuarioRepository.findById(dadosMedicamento.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Dependente dependente = null;
        if (dadosMedicamento.dependenteId() != null) {
            dependente = dependenteRepository.findById(dadosMedicamento.dependenteId())
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


        Medicamento medicamento = new Medicamento(dadosMedicamento, usuario, dependente);
        medicamento.setFrequenciaUso(frequenciaUso);

        // Salvando e retornando o medicamento
        return medicamentoRepository.save(medicamento);
    }
}
