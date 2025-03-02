package com.medtrack.medtrack.service.medicamento;

import com.medtrack.medtrack.model.dependente.Dependente;
import com.medtrack.medtrack.model.medicamento.FrequenciaUso;
import com.medtrack.medtrack.model.medicamento.Medicamento;
import com.medtrack.medtrack.model.medicamento.dto.DadosMedicamento;
import com.medtrack.medtrack.model.medicamento.dto.DadosMedicamentoPut;
import com.medtrack.medtrack.model.usuario.Usuario;
import com.medtrack.medtrack.repository.DependenteRepository;
import com.medtrack.medtrack.repository.FrequenciaUsoRepository;
import com.medtrack.medtrack.repository.MedicamentoRepository;
import com.medtrack.medtrack.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.Arrays;

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
        Usuario usuario = usuarioRepository.findById(dadosMedicamento.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Dependente dependente = null;
        if (dadosMedicamento.dependenteId() != null) {
            dependente = dependenteRepository.findById(dadosMedicamento.dependenteId())
                    .orElseThrow(() -> new IllegalArgumentException("Dependente não encontrado"));
        }

        FrequenciaUso frequenciaUso = dadosMedicamento.frequenciaUso().id() != null
                ? frequenciaUsoRepository.findById(dadosMedicamento.frequenciaUso().id())
                .orElseThrow(() -> new IllegalArgumentException("Frequência de uso não encontrada"))
                : frequenciaUsoRepository.save(new FrequenciaUso(dadosMedicamento.frequenciaUso()));

        Medicamento medicamento = new Medicamento(dadosMedicamento, usuario, dependente);
        medicamento.setFrequenciaUso(frequenciaUso);

        return medicamentoRepository.save(medicamento);
    }

//    public Medicamento atualizarMedicamento(DadosMedicamento dadosMedicamento, Medicamento medicamentoExistente) {
//        BeanUtils.copyProperties(dadosMedicamento, medicamentoExistente, getNullPropertyNames(dadosMedicamento));
//        return medicamentoExistente;
//    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Arrays.stream(wrappedSource.getPropertyDescriptors())
                .map(PropertyDescriptor::getName)
                .filter(name -> wrappedSource.getPropertyValue(name) == null)
                .toArray(String[]::new);
    }

    public Medicamento atualizarMedicamento( @Valid DadosMedicamentoPut dadosMedicamentoPut) {
        var medicamento= medicamentoRepository.getMedicamentoById(dadosMedicamentoPut.id());
        BeanUtils.copyProperties(medicamento, dadosMedicamentoPut, getNullPropertyNames(dadosMedicamentoPut));
        return medicamento;
    }
}
