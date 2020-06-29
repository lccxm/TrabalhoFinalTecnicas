package com.GustavoLuccaNicolas.bookStore.casosDeUso.servicos;

import com.GustavoLuccaNicolas.bookStore.entidades.Genero;
import com.GustavoLuccaNicolas.bookStore.entidades.Livro;
import com.GustavoLuccaNicolas.bookStore.interfaceRemota.RepositorioLivrosImpl;
import com.GustavoLuccaNicolas.bookStore.interfaceRemota.RepositorioVendasImpl

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServicosPagina {
    private RepositorioVendasImpl rVendas;
    private RepositorioLivrosImpl rLivros;
    private Livro livro;

    ServicosPagina(RepositorioVendasImpl rVendas, RepositorioLivrosImpl rLivros){
        this.rVendas = rVendas;
        this.rLivros = rLivros;
    }

    public ArrayList<Livro> pesquisaPorTitulo(String titulo){
        List<Livro> livros = rLivros.findAll();
        List<Livro> livrosEncontrados = new ArrayList<Livro>;
        for(Livro l : livros){
            if(titulo.equalsIgnoreCase(l.getTitulo())){
                livrosEncontrados.add(l);
            }
        }
        return livrosEncontrados;
    }

    public ArrayList<Livro> pesquisaPorGenero(Genero genero){
        ArrayList<Livro> livros = rLivros.findAll();
        ArrayList<Livro> livrosEncontrados = new ArrayList<Livro>;
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