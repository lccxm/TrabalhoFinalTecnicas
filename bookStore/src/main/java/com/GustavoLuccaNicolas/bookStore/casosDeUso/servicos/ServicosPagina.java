package com.GustavoLuccaNicolas.bookStore.casosDeUso.servicos;

import com.GustavoLuccaNicolas.bookStore.entidades.Genero;
import com.GustavoLuccaNicolas.bookStore.entidades.Livro;
import com.GustavoLuccaNicolas.bookStore.interfaceRemota.RepositorioLivrosImpl;
import com.GustavoLuccaNicolas.bookStore.interfaceRemota.RepositorioVendasImpl
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicosPagina {
    private RepositorioVendasImpl rVendas;
    private RepositorioLivrosImpl rLivros;
    private Livro livro;

    @Autowired
    ServicosPagina(RepositorioVendasImpl rVendas, RepositorioLivrosImpl rLivros){
        this.rVendas = rVendas;
        this.rLivros = rLivros;
    }

    public List<Livro> pesquisaPorTitulo(String titulo){
        List<Livro> livros = rLivros.findAll();
        List<Livro> livrosEncontrados = new ArrayList<Livro>;
        for(Livro l : livros){
            if(titulo.equalsIgnoreCase(l.getTitulo())){
                livrosEncontrados.add(l);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> pesquisaPorGenero(Genero genero){
        List<Livro> livros = rLivros.findAll();
        List<Livro> livrosEncontrados = new ArrayList<Livro>();
        for(Livro l : livros){
            if(genero == l.getGenero()){
                livrosEncontrados.add(l);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> getBestSellers(){
        List<Livro> livros = rLivros.findAll();
        List<Livro> listaOrdenada = livros.stream()
                .sorted(Comparator.comparing(Livro::getnVendas))
                .collect(Collectors.toList());
        Collections.reverse(listaOrdenada);
        return listaOrdenada;
    }
}