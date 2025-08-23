package com.github.iarlo.livraria.service;

import java.util.List;

import com.github.iarlo.livraria.model.Livro;
import com.github.iarlo.livraria.repository.ListaRepository;

public class ListaService {

    private final ListaRepository listaRepository = ListaRepository.getInstance();

    public void adicionarLivroLido(Livro livro) {
        listaRepository.addLivroLido(livro);
    }

    public void adicionarLivroNaLista(Livro livro) {
        listaRepository.addLivroLista(livro);
    }

    public void removeLivroLido(Livro livro) {
        listaRepository.removeLivroLido(livro);
    }

    public void removeLivroLista(Livro livro) {
        listaRepository.removeLivroLista(livro);
    }

    public List<Livro> obterLista() {
        return listaRepository.getLivrosLista();
    }

    public List<Livro> obterLivrosLidos() {
        return listaRepository.getLivrosLidos();
    }
}
