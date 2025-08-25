package com.github.iarlo.livraria.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.iarlo.livraria.model.Livro;
import com.github.iarlo.livraria.service.ListaService;
import com.github.iarlo.livraria.service.LivrariaService;

@Controller
public class InicioController {

    private final LivrariaService livrariaService = new LivrariaService();
    private final ListaService listaService = new ListaService();

    @GetMapping("/")
    public String index(Model model) {
        List<Livro> livroslidos = listaService.obterLivrosLidos();
        List<Livro> livroslista = listaService.obterLista();

        // Vamos reverter a ordem da lista para exibir os livros mais recentes primeiro
        List<Livro> livrosaicionados = new ArrayList<>(livrariaService.listarTodos());
        Collections.reverse(livrosaicionados);

        model.addAttribute("livroslidos", livroslidos);
        model.addAttribute("livroslista", livroslista);
        model.addAttribute("livrosadicionados", livrosaicionados);

        return "index";
    }

}
