package com.github.iarlo.livraria.controller;

import com.github.iarlo.livraria.model.Livro;
import com.github.iarlo.livraria.service.ListaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lista")
public class ListaController {

    private final ListaService listaService = new ListaService();

    @GetMapping("/lidos")
    public String listarLivrosLidos(Model model) {
        List<Livro> livrosLidos = listaService.obterLivrosLidos();
        model.addAttribute("livrosLidos", livrosLidos);
        return "lista-livros-lidos";
    }

    @GetMapping
    public String listarLivrosLista(Model model) {
        List<Livro> livrosParaLer = listaService.obterLista();
        model.addAttribute("livrosParaLer", livrosParaLer);
        return "lista-leitura";
    }

    @PostMapping("/lidos")
    public String adicionarLivroLido(@ModelAttribute Livro livro) {
        listaService.adicionarLivroLido(livro);
        return "redirect:/";
    }

    @PostMapping
    public String adicionarLivroLista(@ModelAttribute Livro livro) {
        listaService.adicionarLivroNaLista(livro);
        return "redirect:/";
    }

}
