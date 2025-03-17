package com.medtrack.medtrack.controller.mobile;

import com.medtrack.medtrack.model.medicamento.Medicamento;
import com.medtrack.medtrack.model.medicamento.dto.DadosMedicamentoMobile;
import com.medtrack.medtrack.model.usuario.Usuario;
import com.medtrack.medtrack.repository.MedicamentoRepository;
import com.medtrack.medtrack.repository.UsuarioRepository;
import com.medtrack.medtrack.service.jwt.JwtService;
import com.medtrack.medtrack.service.medicamento.MedicamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.medtrack.medtrack.model.usuario.CategoriaUsuario.ADMINISTRADOR;
import static com.medtrack.medtrack.model.usuario.CategoriaUsuario.PESSOAL;

@RestController
@RequestMapping("medicamento/mobile")
public class MedicamentoMobileController {

    private final MedicamentoRepository medicamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final MedicamentoService medicamentoService;

    public MedicamentoMobileController(MedicamentoRepository medicamentoRepository, UsuarioRepository usuarioRepository,
                                       JwtService jwtService, MedicamentoService medicamentoService ){
        this.medicamentoRepository = medicamentoRepository;
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.medicamentoService = medicamentoService;
    }


    @GetMapping("/lista")
    public ResponseEntity<List<DadosMedicamentoMobile>> getMedicamentos(@RequestHeader("Authorization") String token) {
        String username = jwtService.extractUsername(token.replace("Bearer ", ""));
        Optional<Usuario> optional = usuarioRepository.findByNomeUsuario(username);

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuario = optional.get();

        List<Medicamento> medicamentos;
        if (ADMINISTRADOR.equals(usuario.getTipoConta()) || PESSOAL.equals(usuario.getTipoConta())) {
            medicamentos = medicamentoRepository.findByUsuarioId(usuario.getId());
        } else {
            medicamentos = medicamentoRepository.findByDependenteId(usuario.getId());
        }

        List<DadosMedicamentoMobile> medicamentosMobile = medicamentos.stream()
                .map(medicamento -> {
                    List<LocalTime> horarios = medicamentoService.calcularHorarios(medicamento);
                    boolean usoContinuo = medicamento.getFrequenciaUso().isUsoContinuo();
                    return new DadosMedicamentoMobile(medicamento, horarios, usoContinuo);
                })
                .filter(medimentoMobile -> !medimentoMobile.horarios().isEmpty())
                .collect(Collectors.toList());

        return ResponseEntity.ok(medicamentosMobile);
    }

}
