package com.gustavoluccanicolas.bookStore.controllers;

import com.gustavoluccanicolas.bookStore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("clientes")
public class ClienteController {

    private final LivroRepository livro;

    @Autowired
    public ClienteController(LivroRepository livro) {
        this.livro = livro;
    }

    @GetMapping
    public ModelAndView findAllClientes() {

        ModelAndView model = new ModelAndView();
        return model.addObject(livro.findAll());
    }

}
