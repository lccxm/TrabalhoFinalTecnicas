package com.GustavoLuccaNicolas.bookStore.casosDeUso.servicos;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;

import static java.util.function.Function.identity;

import java.awt.List;

import com.GustavoLuccaNicolas.bookStore.casosDeUso.politica.Venda;


import com.GustavoLuccaNicolas.bookStore.entidades.Cliente;
import com.GustavoLuccaNicolas.bookStore.entidades.Genero;
import com.GustavoLuccaNicolas.bookStore.entidades.Livro;

import com.GustavoLuccaNicolas.bookStore.interfaceRemota.RepositorioClientesImpl;
import com.GustavoLuccaNicolas.bookStore.interfaceRemota.RepositorioLivrosImpl;
import com.GustavoLuccaNicolas.bookStore.interfaceRemota.RepositorioVendasImpl;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;

public class servicosCliente{

    private RepositorioClientesImpl rClientes;
    private RepositorioVendasImpl rVendas;
    private RepositorioLivrosImpl rLivros;
    private ServicosPagina serv;
    


    public servicosCliente(RepositorioClientesImpl rClientes, RepositorioVendasImpl rVendas, RepositorioLivrosImpl rLivros, ServicoPagina serv){
        this.rClientes = rClientes;
        this.rLivros = rLivros;
        this.rVendas = rVendas;
        this.serv = new ServicosPagina(rVendas, rLivros);
    }

    public Cliente recuperarDadosCliente(Long cpf){
        Cliente c = (Cliente) rClientes.findClienteByCpf(cpf);
        return c;
    }

    public List<Venda> recuperarComprasPassadas(Cliente cliente){
        List<Venda> vendas = rVendas.findAllByCliente(cliente);
        return vendas;
    }

    public List<Livro> recuperarRecomendacoes(String cpf){ 
        Cliente cliente = rClientes.findByCpf(cpf);
        List<Livro> bestSellers = serv.getBestSellers();
        Genero favorito;
        List<Livro> livros = rVendas.findByCliente(cliente).stream()
                .map(vendas -> vendas.getLivros())
                .flatMap(List::stream).collect(Collectors.toList());
        Map<Genero, Integer> freq = livros.stream().map(livro -> livro.getGenero())
                .collect(Collectors.toMap(identity(), v -> 1, Integer::sum));
        int maxValueInMap=(Collections.max(freq.values()));
        for (Map.Entry<Genero, Integer> entry : freq.entrySet()) {  
            if (entry.getValue()==maxValueInMap) {
                favorito = entry.getKey();    
            }
        }
        return bestSellers.stream().filter(livro -> livro.getGenero() == favorito).collect(Collectors.toList());
    }


    public Venda criaVenda(Cliente cliente){
       return new Venda(cliente);
    }
}

