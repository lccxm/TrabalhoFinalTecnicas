package com.gustavoluccanicolas.bookstore.controllers;

import com.gustavoluccanicolas.bookstore.models.Cliente;
import com.gustavoluccanicolas.bookstore.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteRepository cliente;

    @Autowired
    public ClienteController(ClienteRepository cliente) {
        this.cliente = cliente;
    }

    @GetMapping
    public ModelAndView findAllClientes() {
        ModelAndView model = new ModelAndView();
        return model.addObject(cliente.findAll());
    }

    @GetMapping
    public ModelAndView findByCpf(Long cpf){
        ModelAndView model = new ModelAndView();
        Cliente c = cliente.findClienteByCpf(cpf);
        return model.addObject("cliente", c);
    }
}
