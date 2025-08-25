package com.github.iarlo.livraria.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.iarlo.livraria.model.Livro;
import com.github.iarlo.livraria.service.ListaService;
import com.github.iarlo.livraria.service.LivrariaService;

@Controller
@RequestMapping("/lista")
public class ListaController {

    private final ListaService listaService = new ListaService();
    private final LivrariaService livrariaService = new LivrariaService();

    @GetMapping("/lidos")
    public String listarLivrosLidos(Model model) {
        List<Livro> livrosLidos = listaService.obterLivrosLidos();
        model.addAttribute("livrosLidos", livrosLidos);
        return "lista-livros-lidos";
    }

    @GetMapping
    public String listarLivrosLista(Model model) {
        List<Livro> livros = listaService.obterLista();
        model.addAttribute("livros", livros);
        return "lista-leitura";
    }

    @PostMapping("/lidos/{id}")
    public String adicionarLivroLido(@PathVariable int id) {
        listaService.adicionarLivroLido(livrariaService.buscarPorId(id));
        return "redirect:/";
    }

    @PostMapping("/{id}")
    public String adicionarLivroLista(@PathVariable int id) {
        listaService.adicionarLivroNaLista(livrariaService.buscarPorId(id));
        return "redirect:/";
    }

}
