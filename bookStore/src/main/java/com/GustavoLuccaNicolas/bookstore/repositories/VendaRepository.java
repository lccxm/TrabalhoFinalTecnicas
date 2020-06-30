package com.gustavoluccanicolas.bookStore.repositories;


import java.util.List;

import com.gustavoluccanicolas.bookStore.models.Venda;
import com.gustavoluccanicolas.bookStore.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Long> {
    List<Venda> findAll();

    List<Venda> findAllByCliente(Cliente cliente);

}
