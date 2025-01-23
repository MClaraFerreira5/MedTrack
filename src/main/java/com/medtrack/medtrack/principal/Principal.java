//package com.medtrack.medtrack.principal;
//
//import com.medtrack.medtrack.model.Categoria;
//import com.medtrack.medtrack.model.usuario.Usuario;
//import com.medtrack.medtrack.repository.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.Scanner;
//
//@Service
//public class Principal {
//    private final UsuarioRepository repositorio;
//
//    @Autowired
//    public Principal(UsuarioRepository repositorio) {
//        this.repositorio = repositorio;
//    }
//
//    public void cadastrarUsuario() {
//        Scanner scanner = new Scanner(System.in);
//        var cadastrarNovo = "s";
//
//        while (cadastrarNovo.equalsIgnoreCase("s")) {
//
//            System.out.println("Digite o nome:");
//            String nome = scanner.nextLine();
//
//            System.out.println("Digite o email:");
//            String email = scanner.nextLine();
//
//            System.out.println("Digite o nome de usuário:");
//            String nomeUsuario = scanner.nextLine();
//
//            System.out.println("Digite a senha:");
//            String senha = scanner.nextLine();
//
//            System.out.println("Selecione o tipo de conta (1 - Administrador, 2- Pessoal):");
//            int tipoContaOpcao = scanner.nextInt();
//            scanner.nextLine();
//
//            Categoria tipoConta;
//            switch (tipoContaOpcao) {
//                case 1:
//                    tipoConta = Categoria.ADMINISTRADOR;
//                    break;
//                case 2:
//                    tipoConta = Categoria.PESSOAL;
//                    break;
//
//                default:
//                    System.out.println("Opção inválida! Definindo como Básica.");
//                    tipoConta = Categoria.PESSOAL;
//                    break;
//            }
//
//            System.out.println("Digite a data de nascimento (dd/MM/yyyy):");
//            LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());
//
//            Usuario novoUsuario = new Usuario(nome, email, nomeUsuario, senha, tipoConta, dataNascimento);
//
//            System.out.println("\nUsuário criado com sucesso!");
//            System.out.println(novoUsuario);
//            repositorio.save(novoUsuario);
//
//            System.out.println("Cadastrar novo usuário? (S/N)");
//            cadastrarNovo = scanner.nextLine();
//
//        }
//        scanner.close();
//
//    }
//
//}
