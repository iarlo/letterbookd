package com.github.iarlo.livraria.model;

import java.time.LocalDate;

public class Review {
    private String texto;
    private String autor;
    private LocalDate dataDoPost;
    private int nota;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataDoPost() {
        return dataDoPost;
    }

    public void setDataDoPost(LocalDate dataDoPost) {
        this.dataDoPost = dataDoPost;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        this.nota = nota;
    }

    public Review(String texto, String autor, LocalDate dataDoPost, int nota) {
        this.texto = texto;
        this.autor = autor;
        this.dataDoPost = dataDoPost;
        setNota(nota);
    }
}
