package com.suaempresa.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;


    public Emprestimo(int id, Livro livro, Usuario usuario, LocalDate dataEmprestimo) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null;
        this.ativo = true;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }


    @Override
    public String toString() {
        String status = ativo ? "Ativo" : "Finalizado";
        String devReal = (dataDevolucao != null) ? dataDevolucao.toString() : "Ainda não devolvido";

        return "ID Empréstimo: " + id +
                "\n  Livro: '" + livro.getTitulo() + "' (ID: " + livro.getId() + ")" +
                "\n  Usuário: '" + usuario.getNome() + "' (ID: " + usuario.getId() + ")" +
                "\n  Data Empréstimo: " + dataEmprestimo +
                "\n  Data Devolução Real: " + devReal +
                "\n  Status: " + status;
    }
}