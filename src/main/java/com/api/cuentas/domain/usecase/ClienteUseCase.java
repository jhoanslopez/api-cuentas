package com.api.cuentas.domain.usecase;

import com.api.cuentas.domain.model.usuario.Cliente;
import com.api.cuentas.domain.model.usuario.gateway.ClienteGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClienteUseCase {

    private final ClienteGateway clienteGateway;

    public List<Cliente> obtenerClientes() {
        return clienteGateway.findAll();
    }

    public Cliente obtenerCliente(Integer id) {
        return clienteGateway.findById(id);
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteGateway.save(cliente);
    }

    public void eliminarCliente(Integer id) {
        clienteGateway.deleteById(id);
    }

}
