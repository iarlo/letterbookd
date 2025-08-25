package com.github.iarlo.livraria.service;

import com.github.iarlo.livraria.model.Livro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LivrariaServiceTest {

    private LivrariaService livrariaService;

    @BeforeEach
    void setUp() {
        livrariaService = new LivrariaService();
    }

    @Test
    void deveAdicionarLivroComSucesso() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", "Clássico");
        livrariaService.adicionar(livro);

        List<Livro> livros = livrariaService.listarTodos();

        assertEquals(1, livros.size());
        assertEquals("Dom Casmurro", livros.get(0).getTitulo());
    }
}