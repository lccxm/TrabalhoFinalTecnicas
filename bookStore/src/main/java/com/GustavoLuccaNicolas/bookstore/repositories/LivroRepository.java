package com.gustavoluccanicolas.bookStore.repositories;

import java.util.List;

import com.gustavoluccanicolas.bookStore.models.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

    List<Livro> findAll();

    Livro findLivroById(Long id);
}
