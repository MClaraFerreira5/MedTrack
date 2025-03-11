package com.medtrack.medtrack.service.usuario;

import com.medtrack.medtrack.model.dependente.Dependente;
import com.medtrack.medtrack.model.usuario.Usuario;
import com.medtrack.medtrack.repository.DependenteRepository;
import com.medtrack.medtrack.repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final DependenteRepository dependenteRepository;


    public UsuarioDetailsService(UsuarioRepository usuarioRepository,
                                 DependenteRepository dependenteRepository) {
        this.usuarioRepository = usuarioRepository;
        this.dependenteRepository = dependenteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
        System.out.println("🔎 Buscando usuário: " + nomeUsuario);

        System.out.println("🔎 Buscando usuário ou dependente: " + nomeUsuario);
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNomeUsuario(nomeUsuario);
        if (usuarioOpt.isEmpty()) {
            Optional<Dependente> dependenteOpt = dependenteRepository.findByNomeUsuario(nomeUsuario);
            if (dependenteOpt.isPresent()) {
                Dependente dependente = dependenteOpt.get();
                return criarUserDetailsDependente(dependente);
            }
            throw new UsernameNotFoundException("Usuário ou dependente não encontrado");
        }

        Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario).orElse(null);
        if (usuario != null) {
            System.out.println("✅ Usuário encontrado: " + usuario.getNomeUsuario());
            return new org.springframework.security.core.userdetails.User(
                    usuario.getNomeUsuario(),
                    usuario.getSenhaHashed(),
                    List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getTipoConta().name())) // ADMINISTRADOR ou PESSOAL
            );
        }

        Dependente dependente = dependenteRepository.findByNomeUsuario(nomeUsuario).orElse(null);
        if (dependente != null) {
            System.out.println("✅ Dependente encontrado: " + dependente.getNomeUsuario());
            return new org.springframework.security.core.userdetails.User(
                    dependente.getNomeUsuario(),
                    dependente.getSenhaHashed(),
                    List.of(new SimpleGrantedAuthority("ROLE_DEPENDENTE")) // Definindo uma role fixa
            );
        }

        throw new UsernameNotFoundException("Usuário ou dependente não encontrado");
    }

    private UserDetails criarUserDetailsDependente(Dependente dependente) {
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_DEPENDENTE"));
        return new org.springframework.security.core.userdetails.User(
                dependente.getNomeUsuario(),
                dependente.getSenhaHashed(),
                authorities
        );
    }


//    private UserDetails criarUserDetails(Usuario usuario) {
//        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getTipoConta().name()));
//        return new org.springframework.security.core.userdetails.User(
//                usuario.getNomeUsuario(),
//                usuario.getSenhaHashed(),
//                authorities
//        );
//    }
}
