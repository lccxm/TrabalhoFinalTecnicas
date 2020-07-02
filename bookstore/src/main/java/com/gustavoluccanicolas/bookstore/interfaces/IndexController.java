package com.gustavoluccanicolas.bookstore.interfaces;

import com.gustavoluccanicolas.bookstore.entidades.Cliente;
import com.gustavoluccanicolas.bookstore.entidades.Livro;
import com.gustavoluccanicolas.bookstore.casosdeuso.repositories.ClienteRepository;
import com.gustavoluccanicolas.bookstore.casosdeuso.repositories.LivroRepository;
import com.gustavoluccanicolas.bookstore.casosdeuso.repositories.services.PaginaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping
    public void addLivroCarrinho(Cliente cliente, Livro livro){
        cliente.getCarrinho().addLivro(livro);
    }

    @PostMapping("/1")
    public ModelAndView getCarrinho(Cliente cliente){
        List<Livro> livros = cliente.getCarrinho().getLivros();
        ModelAndView model = new ModelAndView();
        return model.addObject("carrinho",livros);
    }


}
