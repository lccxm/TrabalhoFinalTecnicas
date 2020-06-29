package com.GustavoLuccaNicolas.bookStore.casosDeUso.servicos;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

import java.util.List;

import com.GustavoLuccaNicolas.bookStore.casosDeUso.politica.Venda;
import com.GustavoLuccaNicolas.bookStore.entidades.Cliente;
import com.GustavoLuccaNicolas.bookStore.entidades.Genero;
import com.GustavoLuccaNicolas.bookStore.entidades.Livro;

import com.GustavoLuccaNicolas.bookStore.interfaceRemota.RepositorioClientesImpl;
import com.GustavoLuccaNicolas.bookStore.interfaceRemota.RepositorioLivrosImpl;
import com.GustavoLuccaNicolas.bookStore.interfaceRemota.RepositorioVendasImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicosCliente {

    private RepositorioClientesImpl rClientes;
    private RepositorioVendasImpl rVendas;
    private RepositorioLivrosImpl rLivros;
    private ServicosPagina serv;
    

    @Autowired
    public ServicosCliente(RepositorioClientesImpl rClientes, RepositorioVendasImpl rVendas, RepositorioLivrosImpl rLivros, ServicosPagina serv){
        this.rClientes = rClientes;
        this.rLivros = rLivros;
        this.rVendas = rVendas;
        this.serv = serv;
    }

    public Cliente recuperarDadosCliente(Long cpf){
        return rClientes.findClienteByCpf(cpf);
    }

    public List<Venda> recuperarComprasPassadas(Cliente cliente){
        return rVendas.findAllByCliente(cliente);
    }

    public List<Livro> recuperarRecomendacoes(Long cpf){
        Cliente cliente = rClientes.findClienteByCpf(cpf);
        List<Livro> bestSellers = serv.getBestSellers();
        Genero favorito = null;
        List<Livro> livros = rVendas.findAllByCliente(cliente).stream()
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
        Genero finalFavorito = favorito;
        return bestSellers.stream().filter(livro -> livro.getGenero() == finalFavorito).collect(Collectors.toList());
    }
}

    public Venda criaVenda(Cliente cliente){
        return new Venda(cliente);
    }
}


}