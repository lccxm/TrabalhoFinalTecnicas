package com.gustavoluccanicolas.bookstore.repositories;

import java.util.List;

import com.gustavoluccanicolas.bookstore.models.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

    List<Livro> findAll();

    Livro findLivroById(Long id);

    List<Livro> findByGenero(String gender);

    Livro findLivroByTitulo(String title);

    List<Livro> findAllByAutor(String author);
}
