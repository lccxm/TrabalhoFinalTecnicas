package com.GustavoLuccaNicolas.bookStore.interfaceRemota;

import com.GustavoLuccaNicolas.bookStore.entidades.Livro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioLivrosImpl extends CrudRepository<Livro, Long> {
    List<Livro> findAll();
    Livro findLivroById(Long id);
}
