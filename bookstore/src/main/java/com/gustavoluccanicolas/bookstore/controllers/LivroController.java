package com.gustavoluccanicolas.bookstore.controllers;

import com.gustavoluccanicolas.bookstore.models.Livro;
import com.gustavoluccanicolas.bookstore.models.enums.Genero;
import com.gustavoluccanicolas.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("livros")
public class LivroController {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping
    public ModelAndView findAllBooks(){
        List<Livro> livro = livroRepository.findAll();
        ModelAndView model = new ModelAndView();
        return model.addObject("livros", livro);
    }

    @GetMapping("/{genero}")
    public ModelAndView findByGender(@PathVariable Genero genero){
        List<Livro> livros = livroRepository.findByGenero(genero.toString());
        ModelAndView model = new ModelAndView();
        return model.addObject("Livros por Genero", livros);
    }

    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        ModelAndView model = new ModelAndView();
        return model.addObject("Livro por id", livro);
    }

    @GetMapping("/{title}")
    public ModelAndView findByTitle(@PathVariable String title){
        Livro livro = livroRepository.findLivroByTitulo(title);
        ModelAndView model = new ModelAndView();
        return model.addObject("livro por titulo", livro);
    }

    @GetMapping("/{author}")
    public ModelAndView findByAuthor(@PathVariable String author){
        List<Livro> livros = livroRepository.findAllByAutor(author);
        ModelAndView model = new ModelAndView();
        return model.addObject("livros por autor", livros);
    }
}

