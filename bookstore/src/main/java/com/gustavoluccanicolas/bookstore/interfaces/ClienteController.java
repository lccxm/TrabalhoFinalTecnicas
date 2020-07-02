package com.gustavoluccanicolas.bookstore.interfaces;

import com.gustavoluccanicolas.bookstore.casosdeuso.repositories.ClienteRepository;
import com.gustavoluccanicolas.bookstore.casosdeuso.repositories.services.ClienteService;
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
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository, ClienteService clienteService) {
        this.clienteRepository = clienteRepository;
        this.clienteService = clienteService;
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

    @GetMapping("/recomendacoes/{cpf}")
    public ModelAndView findRecomendacoes(@PathVariable String cpf){
        ModelAndView model = new ModelAndView("cliente/recomendacoes");
        return model.addObject("livros", clienteService.recuperarRecomendacoes(cpf));
    }

}
