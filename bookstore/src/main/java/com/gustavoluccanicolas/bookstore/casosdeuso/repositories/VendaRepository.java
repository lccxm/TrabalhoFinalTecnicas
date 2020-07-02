package com.gustavoluccanicolas.bookstore.casosdeuso.repositories;

import java.util.List;

import com.gustavoluccanicolas.bookstore.entidades.Venda;
import com.gustavoluccanicolas.bookstore.entidades.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Long> {
    List<Venda> findAll();

    List<Venda> findAllByCliente(Cliente cliente);

}
