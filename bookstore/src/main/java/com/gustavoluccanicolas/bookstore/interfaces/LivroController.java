package com.gustavoluccanicolas.bookstore.interfaces;

import com.gustavoluccanicolas.bookstore.entidades.Livro;
import com.gustavoluccanicolas.bookstore.entidades.enums.Genero;
import com.gustavoluccanicolas.bookstore.casosdeuso.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LivroController {

    @Autowired
    private final LivroRepository livroRepository;

    @Autowired
    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/livros")
    public ModelAndView findAllBooks(){
        List<Livro> livro = livroRepository.findAll();
        ModelAndView model = new ModelAndView("index");
        System.out.println(livro);
        return model.addObject("livros", livro);
    }

    @GetMapping("/genero/{genero}")
    public ModelAndView findByGender(@PathVariable Genero genero){
        List<Livro> livros = livroRepository.findByGenero(genero.toString());
        ModelAndView model = new ModelAndView();
        return model.addObject("bookGender", livros);
    }

    @GetMapping("/id/{id}")
    public ModelAndView findById(@PathVariable Long id){
        Livro livro = livroRepository.findLivroById(id);
        ModelAndView model = new ModelAndView("livro/livro");
        return model.addObject("livro", livro);
    }

    @GetMapping("/titulo/{title}")
    public ModelAndView findByTitle(@PathVariable String title){
        Livro livro = livroRepository.findLivroByTitulo(title);
        ModelAndView model = new ModelAndView();
        return model.addObject("bookTitle", livro);
    }

    @GetMapping("/autor/{author}")
    public ModelAndView findByAuthor(@PathVariable String author){
        List<Livro> livros = livroRepository.findAllByAutor(author);
        ModelAndView model = new ModelAndView();
        return model.addObject("bookAuthor", livros);
    }

}

