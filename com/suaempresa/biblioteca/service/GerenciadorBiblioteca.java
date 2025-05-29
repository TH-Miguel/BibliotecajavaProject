package com.suaempresa.biblioteca.service;

import com.suaempresa.biblioteca.model.Emprestimo;
import com.suaempresa.biblioteca.model.Livro;
import com.suaempresa.biblioteca.model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GerenciadorBiblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    private int proximoIdLivro;
    private int proximoIdUsuario;
    private int proximoIdEmprestimo;

    public GerenciadorBiblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.proximoIdLivro = 1;
        this.proximoIdUsuario = 1;
        this.proximoIdEmprestimo = 1;
    }



    public Livro cadastrarLivro(String titulo, String autor, String genero) {

        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo) && l.getAutor().equalsIgnoreCase(autor)) {
                System.out.println("ERRO: Livro com este título e autor já existe.");
                return null;
            }
        }
        Livro novoLivro = new Livro(proximoIdLivro++, titulo, autor, genero);
        livros.add(novoLivro);
        System.out.println("Livro cadastrado com sucesso! ID: " + novoLivro.getId());
        return novoLivro;
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro l : livros) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    public List<Livro> listarTodosLivros() {
        return new ArrayList<>(livros); // Retorna uma cópia
    }

    public boolean atualizarLivro(int id, String novoTitulo, String novoAutor, String novoGenero) {
        Livro livro = buscarLivroPorId(id);
        if (livro != null) {
            livro.setTitulo(novoTitulo);
            livro.setAutor(novoAutor);
            livro.setGenero(novoGenero);
            System.out.println("Livro ID " + id + " atualizado com sucesso!");
            return true;
        }
        System.out.println("ERRO: Livro com ID " + id + " não encontrado.");
        return false;
    }

    public boolean excluirLivro(int id) {
        Livro livro = buscarLivroPorId(id);
        if (livro != null) {
            if (!livro.isDisponivel()) { // Não pode excluir se estiver emprestado
                System.out.println("ERRO: Livro ID " + id + " não pode ser excluído, está emprestado.");
                return false;
            }
            livros.remove(livro);
            System.out.println("Livro ID " + id + " excluído com sucesso!");
            return true;
        }
        System.out.println("ERRO: Livro com ID " + id + " não encontrado.");
        return false;
    }



    public Usuario cadastrarUsuario(String nome, String matricula) {

        for (Usuario u : usuarios) {
            if (u.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.println("ERRO: Usuário com esta matrícula já existe.");
                return null;
            }
        }
        Usuario novoUsuario = new Usuario(proximoIdUsuario++, nome, matricula);
        usuarios.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso! ID: " + novoUsuario.getId());
        return novoUsuario;
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null; // Não encontrou
    }

    public List<Usuario> listarTodosUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public boolean atualizarUsuario(int id, String novoNome, String novaMatricula) {
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario != null) {
            usuario.setNome(novoNome);
            usuario.setMatricula(novaMatricula);
            System.out.println("Usuário ID " + id + " atualizado com sucesso!");
            return true;
        }
        System.out.println("ERRO: Usuário com ID " + id + " não encontrado.");
        return false;
    }

    public boolean excluirUsuario(int id) {
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario != null) {

            for (Emprestimo e : emprestimos) {
                if (e.getUsuario().getId() == id && e.isAtivo()) {
                    System.out.println("ERRO: Usuário ID " + id + " não pode ser excluído, possui empréstimos ativos.");
                    return false;
                }
            }
            usuarios.remove(usuario);
            System.out.println("Usuário ID " + id + " excluído com sucesso!");
            return true;
        }
        System.out.println("ERRO: Usuário com ID " + id + " não encontrado.");
        return false;
    }



    public Emprestimo registrarEmprestimo(int idLivro, int idUsuario) {
        Livro livro = buscarLivroPorId(idLivro);
        Usuario usuario = buscarUsuarioPorId(idUsuario);

        if (livro == null) {
            System.out.println("ERRO: Livro com ID " + idLivro + " não encontrado.");
            return null;
        }
        if (usuario == null) {
            System.out.println("ERRO: Usuário com ID " + idUsuario + " não encontrado.");
            return null;
        }
        if (!livro.isDisponivel()) {
            System.out.println("ERRO: O livro '" + livro.getTitulo() + "' não está disponível para empréstimo.");
            return null;
        }


        LocalDate dataHoje = LocalDate.now();
        Emprestimo novoEmprestimo = new Emprestimo(proximoIdEmprestimo++, livro, usuario, dataHoje);


        livro.setDisponivel(false);

        emprestimos.add(novoEmprestimo);
        System.out.println("Empréstimo registrado com sucesso! ID: " + novoEmprestimo.getId());
        return novoEmprestimo;
    }

    public boolean encerrarEmprestimo(int idEmprestimo) {
        Emprestimo emprestimo = null;
        for (Emprestimo e : emprestimos) {
            if (e.getId() == idEmprestimo) {
                emprestimo = e;
                break;
            }
        }

        if (emprestimo == null) {
            System.out.println("ERRO: Empréstimo com ID " + idEmprestimo + " não encontrado.");
            return false;
        }
        if (!emprestimo.isAtivo()) {
            System.out.println("ERRO: Este empréstimo já foi encerrado.");
            return false;
        }


        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimo.setAtivo(false);
        emprestimo.getLivro().setDisponivel(true); // Marca o livro como disponível novamente

        System.out.println("Empréstimo ID " + idEmprestimo + " encerrado (livro devolvido).");
        return true;
    }

    public List<Emprestimo> listarTodosEmprestimos() {
        return new ArrayList<>(emprestimos);
    }

    public List<Emprestimo> consultarEmprestimosAtivos() {
        List<Emprestimo> ativos = new ArrayList<>();
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo()) {
                ativos.add(e);
            }
        }
        return ativos;
    }

    public List<Emprestimo> consultarEmprestimosFinalizados() {
        List<Emprestimo> finalizados = new ArrayList<>();
        for (Emprestimo e : emprestimos) {
            if (!e.isAtivo()) {
                finalizados.add(e);
            }
        }
        return finalizados;
    }

    public List<Emprestimo> consultarHistoricoUsuario(int idUsuario) {
        List<Emprestimo> historico = new ArrayList<>();
        for (Emprestimo e : emprestimos) {
            if (e.getUsuario().getId() == idUsuario) {
                historico.add(e);
            }
        }
        return historico;
    }
}