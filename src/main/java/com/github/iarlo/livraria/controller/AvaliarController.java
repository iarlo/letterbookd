package com.github.iarlo.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.iarlo.livraria.model.Livro;
import com.github.iarlo.livraria.model.Review;
import com.github.iarlo.livraria.service.ListaService;
import com.github.iarlo.livraria.service.LivrariaService;

@Controller
@RequestMapping("/avaliar")
public class AvaliarController {

    private final LivrariaService livrariaService = new LivrariaService();
    private final ListaService listaService = new ListaService();

    @GetMapping("/{id}")
    public String exibirFormularioAvaliar(@PathVariable int id, Model model) {
        Livro livro = livrariaService.buscarPorId(id);
        model.addAttribute("livro", livro);
        return "avaliar";
    }

    @PostMapping("/{id}")
    public String avaliar(@ModelAttribute Review review, @PathVariable int id) {
        livrariaService.adicionarReview(id, review);
        listaService.adicionarLivroLido(livrariaService.buscarPorId(id));
        return "redirect:/livros/{id}";
    }

}
