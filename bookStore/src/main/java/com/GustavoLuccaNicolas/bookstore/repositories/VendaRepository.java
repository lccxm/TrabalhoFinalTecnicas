package com.gustavoluccanicolas.bookstore.repositories;


import java.util.List;

import com.gustavoluccanicolas.bookstore.models.Venda;
import com.gustavoluccanicolas.bookstore.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Long> {
    List<Venda> findAll();

    List<Venda> findAllByCliente(Cliente cliente);

}
