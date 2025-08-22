package com.github.iarlo.livraria.service;

import com.github.iarlo.livraria.model.Livro;
import com.github.iarlo.livraria.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LivrariaService {

    private final LivroRepository livroRepository = new LivroRepository();
    private final AtomicInteger geradorId = new AtomicInteger(1);

    public List<Livro> listarTodos() {
        return livroRepository.buscarTodos();
    }

    
    public Livro buscarPorId(int id) {
        return livroRepository.buscarPorId(id);
    }

    public Livro adicionar(Livro livro) {
        validarLivro(livro); 
        verificarDuplo(livro); 

        int id = geradorId.getAndIncrement();
        livroRepository.editar(id, livro); 
        return livro;
    }

    public Livro editar(int id, Livro novoLivro) {
        validarLivro(novoLivro);

        Livro livrojaexiste = livroRepository.buscarPorId(id);
        if (livrojaexiste != null) {
            livrojaexiste.setTitulo(novoLivro.getTitulo());
            livrojaexiste.setAutor(novoLivro.getAutor());
            livroRepository.editar(id, livrojaexiste);
            return livrojaexiste;
        }
        return null;
    }

    public void excluir(int id) {
        livroRepository.excluir(id);
    }

    // TITULO E AUTOR NÃO PODEM SAR VAZIOS
    private void validarLivro(Livro livro) {
        if (livro.getTitulo() == null || livro.getTitulo().isBlank()) {
            throw new IllegalArgumentException("Título não pode ser vazio.");
        }
        if (livro.getAutor() == null || livro.getAutor().isBlank()) {
            throw new IllegalArgumentException("Autor não pode ser vazio.");
        }
    }

    // EVITA DUPLICAÇÃO DE LIVRO
    private void verificarDuplo(Livro livro) {
        boolean existe = livroRepository.buscarTodos().stream()
            .anyMatch(l -> l.getTitulo().equalsIgnoreCase(livro.getTitulo())
                        && l.getAutor().equalsIgnoreCase(livro.getAutor()));
        if (existe) {
            throw new IllegalArgumentException("Livro já cadastrado: " 
                                               + livro.getTitulo() + " - " + livro.getAutor());
        }
    }
}
