package com.medtrack.medtrack.model.dependente;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class DependenteDetails implements UserDetails {
    private final Dependente dependente;

    public DependenteDetails(Dependente dependente) {
        this.dependente = dependente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // Dependente não tem permissões específicas
    }

    @Override
    public String getPassword() {
        return dependente.getSenhaHashed();
    }

    @Override
    public String getUsername() {
        return dependente.getNomeUsuario();
    }

    public Dependente getDependente() {
        return dependente;
    }

}

