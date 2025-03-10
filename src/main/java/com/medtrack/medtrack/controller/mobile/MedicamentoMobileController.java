package com.medtrack.medtrack.controller.mobile;

import com.medtrack.medtrack.model.medicamento.Medicamento;
import com.medtrack.medtrack.model.medicamento.dto.DadosMedicamentoMobile;
import com.medtrack.medtrack.model.usuario.Usuario;
import com.medtrack.medtrack.repository.MedicamentoRepository;
import com.medtrack.medtrack.repository.UsuarioRepository;
import com.medtrack.medtrack.service.jwt.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("medicamento/mobile")
public class MedicamentoMobileController {

    private final MedicamentoRepository medicamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;

    public MedicamentoMobileController(MedicamentoRepository medicamentoRepository, UsuarioRepository usuarioRepository,
                                       JwtService jwtService) {
        this.medicamentoRepository = medicamentoRepository;
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
    }

    public ResponseEntity<List<DadosMedicamentoMobile>> getMedicamentos(@RequestHeader("Authorization") String token) {
        String username = jwtService.extractUsername(token.replace("Bearer ", ""));
        Optional<Usuario> optional = usuarioRepository.findByNomeUsuario(username);

        if (optional.isEmpty()) {
            return (ResponseEntity<List<DadosMedicamentoMobile>>) ResponseEntity.notFound();
        }

        Usuario usuario = optional.get();

        List<Medicamento> medicamentos = medicamentoRepository.findByUsuarioId(usuario.getId());
        List<DadosMedicamentoMobile> medicamentosMobile = medicamentos.stream()
                .map(DadosMedicamentoMobile::new)
                .toList();

        return ResponseEntity.ok(medicamentosMobile);
    }
}
