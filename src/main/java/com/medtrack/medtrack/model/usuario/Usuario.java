package com.medtrack.medtrack.model.usuario;

import com.medtrack.medtrack.model.medicamento.Medicamento;
import com.medtrack.medtrack.model.usuario.dto.DadoUsuarioCadastro;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private CategoriaUsuario tipoConta;
    private String nome;
    private String email;
    private String senhaHashed;
    private LocalDate dataNascimento;
    private String nomeUsuario;
    private String numeroTelefone;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Medicamento> medicamentos = new ArrayList<>();

    public Usuario(@Valid DadoUsuarioCadastro dados) {
        nome = dados.nome();
        email = dados.email();
        tipoConta = dados.categoria();
        numeroTelefone = dados.numeroTelefone();
        senhaHashed = hashSenha(dados.senha());
        dataNascimento = dados.dataNascimento();
        nomeUsuario = dados.nomeUsuario();
    }

    private static String hashSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(Integer.toHexString(0xFF & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao hash a senha", e);
        }
    }
}





