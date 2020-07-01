package com.gustavoluccanicolas.bookstore.controllers;

import com.gustavoluccanicolas.bookstore.models.Livro;
import com.gustavoluccanicolas.bookstore.models.enums.Genero;
import com.gustavoluccanicolas.bookstore.repositories.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private final LivroRepository livroRepository;

    public IndexController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/")
    public ModelAndView findAllBooks(){
        List<Livro> livro = livroRepository.findAll();
        ModelAndView model = new ModelAndView("index");
        return model.addObject("livros", livro);
    }

}
