package br.edu.ifba.demo.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifba.demo.frontend.dto.GeneroDTO;
import br.edu.ifba.demo.frontend.service.GeneroService;

@Controller
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @PostMapping("/salvar")
    public String salvarGenero(@ModelAttribute("genero") GeneroDTO generoDTO, RedirectAttributes redirectAttributes) {
        boolean sucesso = generoService.salvarEatualizar(generoDTO);
        if (sucesso) {
            redirectAttributes.addFlashAttribute("mensagem", "Gênero salvo com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar gênero!");
        }
        return "redirect:/livro/novo";  // Confirme se esta URL está correta
    }

    @GetMapping("/editar/{id}")
    public String editarGenero(@PathVariable Long id, Model model) {
        GeneroDTO generoDTO = generoService.findById(id); // Busca o gênero pelo ID
        model.addAttribute("generoEditar", generoDTO); // Adiciona o gênero ao modelo
        model.addAttribute("generos", generoService.listAllGeneros()); // Mantém a lista de gêneros
        return "livro/novo"; // Retorna para a mesma página de criação de livro
    }


    @GetMapping("/deletar/{id}")
    public String deletarGenero(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        generoService.deletarGenero(id);
        redirectAttributes.addFlashAttribute("mensagem", "Gênero excluído com sucesso!");
        return "redirect:/livro/novo";  // Redireciona para o formulário de criação de livro
    }

    @PostMapping("/atualizar")
    public String atualizarGenero(@ModelAttribute("genero") GeneroDTO generoDTO, RedirectAttributes redirectAttributes) {
        boolean sucesso = generoService.salvarEatualizar(generoDTO);
        if (sucesso) {
            redirectAttributes.addFlashAttribute("mensagem", "Gênero atualizado com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("erro", "Erro ao atualizar gênero!");
        }
        return "redirect:/livro/novo";  // Redireciona para o formulário de novo livro
    }

    


}
