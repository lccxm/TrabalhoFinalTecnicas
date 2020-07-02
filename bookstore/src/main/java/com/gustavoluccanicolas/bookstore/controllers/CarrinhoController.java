package com.gustavoluccanicolas.bookstore.controllers;

import com.gustavoluccanicolas.bookstore.models.Cliente;
import com.gustavoluccanicolas.bookstore.models.Livro;
import com.gustavoluccanicolas.bookstore.models.Venda;
import com.gustavoluccanicolas.bookstore.repositories.ClienteRepository;
import com.gustavoluccanicolas.bookstore.repositories.LivroRepository;
import com.gustavoluccanicolas.bookstore.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CarrinhoController {

    private final ClienteRepository clienteRepository;
    private final LivroRepository livroRepository;

    @Autowired
    public CarrinhoController(ClienteRepository clienteRepository, LivroRepository livroRepository){
        this.clienteRepository = clienteRepository;
        this.livroRepository = livroRepository;
    }


}
