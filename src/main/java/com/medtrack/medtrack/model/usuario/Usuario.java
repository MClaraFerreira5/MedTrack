package com.medtrack.medtrack.model.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.medtrack.medtrack.model.Categoria;
import com.medtrack.medtrack.model.medicamento.Medicamento;
import jakarta.persistence.*;
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
    @JsonProperty("id")
    private long id;

    @Enumerated(EnumType.STRING)
    @JsonProperty("tipo_conta")
    private Categoria tipoConta;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("email")
    private String email;

    @JsonProperty("senha")
    private String senhaHashed;

    @JsonProperty("dataNascimento")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(unique = true)
    @JsonProperty("nome_usuario")
    private String nomeUsuario;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Medicamento> medicamentos = new ArrayList<>();

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





