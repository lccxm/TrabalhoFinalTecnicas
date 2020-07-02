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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("vendas")
public class VendaController {

    private final VendaRepository vendaRepository;
    private final ClienteRepository clienteRepository;


    @Autowired
    public VendaController(VendaRepository vendaRepository, ClienteRepository clienteRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/")
    public ModelAndView findAll(){
        Iterable<Venda> vendas = vendaRepository.findAll();
        ModelAndView model = new ModelAndView("cliente/vendas");
        model.addObject("vendas", vendas);
        return model;
    }

    @GetMapping("/{cpf}")
    public ModelAndView findAllByCliente(@PathVariable String cpf){
        Iterable<Venda> vendas = vendaRepository.findAllByCliente(clienteRepository.findByCpf(cpf));
        ModelAndView model = new ModelAndView("cliente/vendas");
        model.addObject("vendas", vendas);
        return model;
    }

//    @PostMapping("/{cpf}/cart/{id}")
//    public void addCart(){
//        List<Livro> carrinho = new ArrayList<>();
//        carrinho.add(livro);
//    }




}
