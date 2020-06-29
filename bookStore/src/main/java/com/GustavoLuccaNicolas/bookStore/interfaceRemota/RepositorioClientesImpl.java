package com.GustavoLuccaNicolas.bookStore.interfaceRemota;

import com.GustavoLuccaNicolas.bookStore.entidades.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioClientesImpl extends CrudRepository<Cliente, Long> {
    List<Cliente> findAll();
    Cliente  findClienteByCpf(Long cpf);
}
