package com.gustavoluccanicolas.bookstore.controllers;

import com.gustavoluccanicolas.bookstore.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public ModelAndView findAllClientes() {

        ModelAndView model = new ModelAndView();
        return model.addObject(clienteRepository.findAll());
    }

    @GetMapping("/{cpf}")
    public ModelAndView findByCpf(@PathVariable String cpf){

        ModelAndView model = new ModelAndView("cliente/cliente");
        return model.addObject("cliente", clienteRepository.findByCpf(cpf));
    }
}
