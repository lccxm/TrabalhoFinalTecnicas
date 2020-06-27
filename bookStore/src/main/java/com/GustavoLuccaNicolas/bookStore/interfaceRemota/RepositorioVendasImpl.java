package com.GustavoLuccaNicolas.bookStore.interfaceRemota;

import com.GustavoLuccaNicolas.bookStore.casosDeUso.politica.Venda;
import com.GustavoLuccaNicolas.bookStore.entidades.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioVendasImpl extends CrudRepository<Venda, Long> {
    List<Venda> findAll();
    List<Venda> findAllByCliente(Cliente cliente);

}
