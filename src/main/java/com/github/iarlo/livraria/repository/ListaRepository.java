package com.github.iarlo.livraria.repository;

import java.util.ArrayList;
import java.util.List;

import com.github.iarlo.livraria.model.Livro;

/**
 * Implementa o padrão de projeto singleton para garantir que a classe seja
 * criada apenas uma vez. Isso é bom pra gente que vai armazenar dados na
 * memória, pois garante que todos os dados sejam armazenados juntos
 *
 * Referência:
 * https://refactoring.guru/pt-br/design-patterns/singleton/java/example#example-1
 */
public class ListaRepository {

    private static ListaRepository instancia;

    private List<Livro> livrosLidos = new ArrayList<>();
    private List<Livro> livrosLista = new ArrayList<>();

    /**
     * O constructor privado serve pra impedir que a classe seja acessada
     * diretamente
     */
    private ListaRepository() {
    }

    /**
     * Se a instancia já tiver sido definida, retorna ela, se não, cria uma nova
     */
    public static ListaRepository getInstance() {
        if (instancia == null) {
            instancia = new ListaRepository();
        }
        return instancia;
    }

    public List<Livro> getLivrosLidos() {
        return livrosLidos;
    }

    public List<Livro> getLivrosLista() {
        return livrosLista;
    }

    public void addLivroLido(Livro livro) {
        livrosLidos.add(livro);
    }

    public void addLivroLista(Livro livro) {
        livrosLista.add(livro);
    }

    public void removeLivroLido(Livro livro) {
        livrosLidos.remove(livro);
    }

    public void removeLivroLista(Livro livro) {
        livrosLista.remove(livro);
    }
}
