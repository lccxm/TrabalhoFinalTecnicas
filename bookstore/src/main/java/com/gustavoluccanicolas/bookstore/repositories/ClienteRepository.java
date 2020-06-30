package com.gustavoluccanicolas.bookstore.repositories;

import java.util.List;

import com.gustavoluccanicolas.bookstore.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    List<Cliente> findAll();

    Cliente findClienteByCpf(Long cpf);
}
