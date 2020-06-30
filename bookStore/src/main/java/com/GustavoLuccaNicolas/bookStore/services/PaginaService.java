package com.gustavoluccanicolas.bookStore.services;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.gustavoluccanicolas.bookStore.models.Livro;
import com.gustavoluccanicolas.bookStore.models.enums.Genero;
import com.gustavoluccanicolas.bookStore.repositories.LivroRepository;
import com.gustavoluccanicolas.bookStore.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaginaService {
    private VendaRepository rVendas;
    private LivroRepository rLivros;
    private Livro livro;

    @Autowired
    PaginaService(VendaRepository rVendas, LivroRepository rLivros) {
        this.rVendas = rVendas;
        this.rLivros = rLivros;
    }

    public List<Livro> pesquisaPorTitulo(String titulo) {
        List<Livro> livros = rLivros.findAll();
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro l : livros) {
            if (titulo.equalsIgnoreCase(l.getTitulo())) {
                livrosEncontrados.add(l);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> pesquisaPorGenero(Genero genero) {
        List<Livro> livros = rLivros.findAll();
        List<Livro> livrosEncontrados = new ArrayList<Livro>();
        for (Livro l : livros) {
            if (genero == l.getGenero()) {
                livrosEncontrados.add(l);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> getBestSellers() {
        List<Livro> livros = rLivros.findAll();
        List<Livro> listaOrdenada = livros.stream()
                .sorted(Comparator.comparing(Livro::getnVendas))
                .collect(Collectors.toList());
        Collections.reverse(listaOrdenada);
        return listaOrdenada;
    }
}
