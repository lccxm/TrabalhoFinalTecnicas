package com.gustavoluccanicolas.bookstore.casosdeuso.repositories;

import java.util.List;
import java.util.Optional;

import com.gustavoluccanicolas.bookstore.entidades.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

    List<Livro> findAll();

    Optional<Livro> findById(Long id);

    Livro findLivroById(Long id);

    List<Livro> findByGenero(String gender);

    Livro findLivroByTitulo(String title);

    List<Livro> findAllByAutor(String author);

}
