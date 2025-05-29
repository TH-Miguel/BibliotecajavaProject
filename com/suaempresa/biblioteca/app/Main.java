package com.suaempresa.biblioteca.app;

import com.suaempresa.biblioteca.model.Emprestimo;
import com.suaempresa.biblioteca.model.Livro;
import com.suaempresa.biblioteca.model.Usuario;
import com.suaempresa.biblioteca.service.GerenciadorBiblioteca;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GerenciadorBiblioteca gerenciador = new GerenciadorBiblioteca();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1: menuLivros(); break;
                case 2: menuUsuarios(); break;
                case 3: menuEmprestimos(); break;
                case 0: System.out.println("Saindo do sistema. Até mais!"); break;
                default: System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println("\n--- Pressione Enter para continuar ---");
            scanner.nextLine();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n===== Sistema de Biblioteca =====");
        System.out.println("1. Gerenciar Livros");
        System.out.println("2. Gerenciar Usuários");
        System.out.println("3. Gerenciar Empréstimos");
        System.out.println("0. Sair");
        System.out.print(">>> ");
    }


    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine();
            }
        }
    }

    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }



    private static void menuLivros() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Livros ---");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Listar Todos os Livros");
            System.out.println("3. Buscar Livro por ID");
            System.out.println("4. Atualizar Livro");
            System.out.println("5. Excluir Livro");
            System.out.println("0. Voltar");
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    System.out.println("\n-- Cadastrar Novo Livro --");
                    String titulo = lerString("Título: ");
                    String autor = lerString("Autor: ");
                    String genero = lerString("Gênero: ");
                    gerenciador.cadastrarLivro(titulo, autor, genero);
                    break;
                case 2:
                    System.out.println("\n-- Lista de Livros --");
                    List<Livro> livros = gerenciador.listarTodosLivros();
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        for (Livro l : livros) {
                            System.out.println(l);
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n-- Buscar Livro --");
                    int idLivroBuscar = lerInteiro("Digite o ID do livro: ");
                    Livro livroEncontrado = gerenciador.buscarLivroPorId(idLivroBuscar);
                    if (livroEncontrado != null) {
                        System.out.println("Livro encontrado:");
                        System.out.println(livroEncontrado);
                    } else {
                        System.out.println("Livro com ID " + idLivroBuscar + " não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("\n-- Atualizar Livro --");
                    int idLivroAtualizar = lerInteiro("Digite o ID do livro a ser atualizado: ");
                    String novoTitulo = lerString("Novo Título: ");
                    String novoAutor = lerString("Novo Autor: ");
                    String novoGenero = lerString("Novo Gênero: ");
                    gerenciador.atualizarLivro(idLivroAtualizar, novoTitulo, novoAutor, novoGenero);
                    break;
                case 5:
                    System.out.println("\n-- Excluir Livro --");
                    int idLivroExcluir = lerInteiro("Digite o ID do livro a ser excluído: ");
                    gerenciador.excluirLivro(idLivroExcluir);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            if (opcao != 0) {
                System.out.println("\n--- Pressione Enter para continuar ---");
                scanner.nextLine();
            }
        } while (opcao != 0);
    }

    private static void menuUsuarios() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Usuários ---");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Todos os Usuários");
            System.out.println("3. Buscar Usuário por ID");
            System.out.println("4. Atualizar Usuário");
            System.out.println("5. Excluir Usuário");
            System.out.println("0. Voltar");
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    System.out.println("\n-- Cadastrar Novo Usuário --");
                    String nome = lerString("Nome: ");
                    String matricula = lerString("Matrícula: ");
                    gerenciador.cadastrarUsuario(nome, matricula);
                    break;
                case 2:
                    System.out.println("\n-- Lista de Usuários --");
                    List<Usuario> usuarios = gerenciador.listarTodosUsuarios();
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        for (Usuario u : usuarios) {
                            System.out.println(u);
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n-- Buscar Usuário --");
                    int idUsuarioBuscar = lerInteiro("Digite o ID do usuário: ");
                    Usuario usuarioEncontrado = gerenciador.buscarUsuarioPorId(idUsuarioBuscar);
                    if (usuarioEncontrado != null) {
                        System.out.println("Usuário encontrado:");
                        System.out.println(usuarioEncontrado);
                    } else {
                        System.out.println("Usuário com ID " + idUsuarioBuscar + " não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("\n-- Atualizar Usuário --");
                    int idUsuarioAtualizar = lerInteiro("Digite o ID do usuário a ser atualizado: ");
                    String novoNome = lerString("Novo Nome: ");
                    String novaMatricula = lerString("Nova Matrícula: ");
                    gerenciador.atualizarUsuario(idUsuarioAtualizar, novoNome, novaMatricula);
                    break;
                case 5:
                    System.out.println("\n-- Excluir Usuário --");
                    int idUsuarioExcluir = lerInteiro("Digite o ID do usuário a ser excluído: ");
                    gerenciador.excluirUsuario(idUsuarioExcluir);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            if (opcao != 0) {
                System.out.println("\n--- Pressione Enter para continuar ---");
                scanner.nextLine();
            }
        } while (opcao != 0);
    }

    private static void menuEmprestimos() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Empréstimos ---");
            System.out.println("1. Registrar Empréstimo");
            System.out.println("2. Encerrar Empréstimo (Devolução)");
            System.out.println("3. Listar Todos os Empréstimos");
            System.out.println("4. Listar Empréstimos Ativos");
            System.out.println("5. Listar Empréstimos Finalizados");
            System.out.println("6. Consultar Histórico de Empréstimos de um Usuário");
            System.out.println("0. Voltar");
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    System.out.println("\n-- Registrar Empréstimo --");
                    int idLivroEmp = lerInteiro("ID do Livro: ");
                    int idUsuarioEmp = lerInteiro("ID do Usuário: ");
                    gerenciador.registrarEmprestimo(idLivroEmp, idUsuarioEmp);
                    break;
                case 2:
                    System.out.println("\n-- Encerrar Empréstimo --");
                    int idEmpEncerrar = lerInteiro("ID do Empréstimo a ser encerrado: ");
                    gerenciador.encerrarEmprestimo(idEmpEncerrar);
                    break;
                case 3:
                    System.out.println("\n-- Todos os Empréstimos --");
                    List<Emprestimo> todosEmprestimos = gerenciador.listarTodosEmprestimos();
                    if (todosEmprestimos.isEmpty()) {
                        System.out.println("Nenhum empréstimo registrado.");
                    } else {
                        for (Emprestimo e : todosEmprestimos) {
                            System.out.println(e + "\n--------------------");
                        }
                    }
                    break;
                case 4:
                    System.out.println("\n-- Empréstimos Ativos --");
                    List<Emprestimo> ativos = gerenciador.consultarEmprestimosAtivos();
                    if (ativos.isEmpty()) {
                        System.out.println("Nenhum empréstimo ativo.");
                    } else {
                        for (Emprestimo e : ativos) {
                            System.out.println(e + "\n--------------------");
                        }
                    }
                    break;
                case 5:
                    System.out.println("\n-- Empréstimos Finalizados --");
                    List<Emprestimo> finalizados = gerenciador.consultarEmprestimosFinalizados();
                    if (finalizados.isEmpty()) {
                        System.out.println("Nenhum empréstimo finalizado.");
                    } else {
                        for (Emprestimo e : finalizados) {
                            System.out.println(e + "\n--------------------");
                        }
                    }
                    break;
                case 6:
                    System.out.println("\n-- Histórico de Empréstimos de Usuário --");
                    int idUsuarioHistorico = lerInteiro("Digite o ID do Usuário: ");
                    List<Emprestimo> historico = gerenciador.consultarHistoricoUsuario(idUsuarioHistorico);
                    if (historico.isEmpty()) {
                        System.out.println("Usuário não possui histórico de empréstimos ou não encontrado.");
                    } else {
                        System.out.println("Histórico de Empréstimos para Usuário ID " + idUsuarioHistorico + ":");
                        for (Emprestimo e : historico) {
                            System.out.println(e + "\n--------------------");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            if (opcao != 0) {
                System.out.println("\n--- Pressione Enter para continuar ---");
                scanner.nextLine();
            }
        } while (opcao != 0);
    }
}