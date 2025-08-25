package com.github.iarlo.livraria.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.iarlo.livraria.model.Livro;
import com.github.iarlo.livraria.service.ArquivosService;
import com.github.iarlo.livraria.service.LivrariaService;

@Controller
@RequestMapping("/livros")
public class LivrariaController {

    private final LivrariaService livrariaService = new LivrariaService();
    private final ArquivosService arquivosService = new ArquivosService("livros");

    // Listar livros
    @GetMapping
    public String listarLivros(Model model) {
        List<Livro> livros = livrariaService.listarTodos();
        model.addAttribute("livroslidos", livros);
        return "index";
    }

    // Adicionar livro (GET para exibir formulário)
    @GetMapping("/adicionar")
    public String exibirFormularioAdicionar(Model model) {
        return "adicionar";
    }

    // Adicionar livro (POST para salvar)
    @PostMapping
    public String adicionarLivro(@ModelAttribute Livro livro) {
        livrariaService.adicionar(livro);
        arquivosService.criarArquivo(livro.getTitulo(), livro.getAutor(), livro.getDescricao());
        return "redirect:/";
    }

    // Editar livro
    @GetMapping("/editar/{id}")
    public String exibirFormularioEditar(@PathVariable int id, Model model) {
        Livro livro = livrariaService.buscarPorId(id);
        model.addAttribute("livro", livro);
        return "form-livro";
    }

    @PostMapping("/editar/{id}")
    public String editarLivro(@PathVariable int id, @ModelAttribute Livro livro) {
        livro.setId(id);
        livrariaService.editar(id, livro);
        return "redirect:/livros";
    }

    // Excluir livro
    @GetMapping("/excluir/{id}")
    public String excluirLivro(@PathVariable int id) {
        livrariaService.excluir(id);
        return "redirect:/";
    }

    // Visualizar detalhes
    @GetMapping("/{id}")
    public String visualizarDetalhes(@PathVariable int id, Model model) {
        Livro livro = livrariaService.buscarPorId(id);
        model.addAttribute("livro", livro);
        model.addAttribute("reviews", livro.getReview());
        return "detalhes";
    }
}
