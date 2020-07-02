package com.gustavoluccanicolas.bookstore.casosdeuso.repositories.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.gustavoluccanicolas.bookstore.entidades.Cliente;
import com.gustavoluccanicolas.bookstore.entidades.Livro;
import com.gustavoluccanicolas.bookstore.entidades.Venda;
import com.gustavoluccanicolas.bookstore.entidades.enums.Genero;
import com.gustavoluccanicolas.bookstore.casosdeuso.repositories.ClienteRepository;
import com.gustavoluccanicolas.bookstore.casosdeuso.repositories.LivroRepository;
import com.gustavoluccanicolas.bookstore.casosdeuso.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.util.function.Function.identity;

@Service
public class ClienteService {

    private static ClienteRepository rClientes;
    private static VendaRepository rVendas;
    private static LivroRepository rLivros;
    private static PaginaService serv;

    private static ClienteRepository repositoryClientes;

    @Autowired
    public ClienteService(ClienteRepository rClientes, VendaRepository rVendas, LivroRepository rLivros, PaginaService serv) {
        ClienteService.rClientes = rClientes;
        ClienteService.rLivros = rLivros;
        ClienteService.rVendas = rVendas;
        ClienteService.serv = serv;
    }

    public List<Cliente> findAll(){

        try {
            return repositoryClientes.findAll();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    public Cliente recuperarDadosCliente(String cpf) {
        return rClientes.findByCpf(cpf);
    }

    public List<Venda> recuperarComprasPassadas(Cliente cliente) {
        return rVendas.findAllByCliente(cliente);
    }

    public List<Livro> recuperarRecomendacoes(String cpf) {
        Cliente cliente = rClientes.findByCpf(cpf);
        List<Livro> bestSellers = serv.getBestSellers();
        Genero favorito = null;
        List<Livro> livros = rVendas.findAllByCliente(cliente).stream()
                .map(vendas -> vendas.getLivros())
                .flatMap(List::stream).collect(Collectors.toList());
        Map<Genero, Integer> freq = livros.stream().map(livro -> livro.getGenero())
                .collect(Collectors.toMap(identity(), v -> 1, Integer::sum));
        int maxValueInMap = (Collections.max(freq.values()));
        for (Map.Entry<Genero, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                favorito = entry.getKey();
            }
        }
        Genero finalFavorito = favorito;
        return bestSellers.stream().filter(livro -> livro.getGenero() == finalFavorito).collect(Collectors.toList());
    }

    public Venda criaVenda(Cliente cliente) {
        return new Venda(cliente);
    }
}
