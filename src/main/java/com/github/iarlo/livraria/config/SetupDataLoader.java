package com.github.iarlo.livraria.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.github.iarlo.livraria.model.Livro;
import com.github.iarlo.livraria.model.Review;
import com.github.iarlo.livraria.service.LivrariaService;

@Configuration
public class SetupDataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        LivrariaService livrariaService = new LivrariaService();

        Livro senhorDosAneis = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "A saga de Frodo para destruir o anel.");
        Review reviewSenhorDosAneis = new Review("Muito bom!", "Fulano", LocalDate.now(), 10);

        Livro harryPotter = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "É leviÔsa, e não leviosÁ!");
        Review reviewHarryPotter = new Review("O livro é massa mas a autora 💀", "Cicrano", LocalDate.now(), 5);

        Livro guiaMochileiro = new Livro("O Guia do Mochileiro das Galáxias", "Douglas Adams", "A resposta para a vida, o universo e tudo mais.");
        Review reviewGuiaMochileiro = new Review("Muito viajado. Amei", "Beltrano", LocalDate.now(), 9);

        livrariaService.adicionar(senhorDosAneis);
        livrariaService.adicionarReview(senhorDosAneis.getId(), reviewSenhorDosAneis);

        livrariaService.adicionar(harryPotter);
        livrariaService.adicionarReview(harryPotter.getId(), reviewHarryPotter);

        livrariaService.adicionar(guiaMochileiro);
        livrariaService.adicionarReview(guiaMochileiro.getId(), reviewGuiaMochileiro);

        livrariaService.adicionar(new Livro("O Hobbit", "J.R.R. Tolkien", "As aventuras de Bilbo Bolseiro."));
    }
}
