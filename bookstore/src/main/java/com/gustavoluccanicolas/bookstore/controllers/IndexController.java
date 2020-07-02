package com.gustavoluccanicolas.bookstore.controllers;

import com.gustavoluccanicolas.bookstore.models.Carrinho;
import com.gustavoluccanicolas.bookstore.models.Cliente;
import com.gustavoluccanicolas.bookstore.models.Livro;
import com.gustavoluccanicolas.bookstore.repositories.ClienteRepository;
import com.gustavoluccanicolas.bookstore.repositories.LivroRepository;
import com.gustavoluccanicolas.bookstore.services.PaginaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.LabelView;
import java.util.List;

@Controller
public class IndexController {

    private final LivroRepository livroRepository;
    private final PaginaService paginaService;
    private final ClienteRepository clienteRepository;

    public IndexController(LivroRepository livroRepository, PaginaService paginaService, ClienteRepository clienteRepository) {
        this.livroRepository = livroRepository;
        this.paginaService = paginaService;
        this.clienteRepository = clienteRepository;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }


    @PostMapping
    public void addLivroCarrinho(Cliente cliente, Livro livro){
        cliente.getCarrinho().addLivro(livro);
    }

    @GetMapping("/")
    public ModelAndView getCarrinho(Cliente cliente){
        List<Livro> livros = cliente.getCarrinho().getLivros();
        ModelAndView model = new ModelAndView();
        return model.addObject("carrinho",livros);
    }


}
