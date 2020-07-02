package com.gustavoluccanicolas.bookstore.controllers;

import com.gustavoluccanicolas.bookstore.models.Livro;
import com.gustavoluccanicolas.bookstore.repositories.LivroRepository;
import com.gustavoluccanicolas.bookstore.services.PaginaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    private final LivroRepository livroRepository;
    private final PaginaService paginaService;
    public IndexController(LivroRepository livroRepository, PaginaService paginaService) {
        this.livroRepository = livroRepository;
        this.paginaService = paginaService;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
