package com.gustavoluccanicolas.bookstore.casosdeuso.repositories;

import java.util.List;

import com.gustavoluccanicolas.bookstore.entidades.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    List<Cliente> findAll();

    Cliente findByCpf(String cpf);
}
