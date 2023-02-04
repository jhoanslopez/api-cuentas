package com.api.cuentas.domain.model.usuario.gateway;


import com.api.cuentas.domain.model.usuario.Cliente;

import java.util.List;

public interface ClienteGateway {

    List<Cliente> findAll();

    Cliente findById(Integer id);

    Cliente save(Cliente cliente);

    void deleteById(Integer id);

}
