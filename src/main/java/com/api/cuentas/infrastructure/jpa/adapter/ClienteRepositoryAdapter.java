package com.api.cuentas.infrastructure.jpa.adapter;

import com.api.cuentas.domain.model.usuario.Cliente;
import com.api.cuentas.domain.model.usuario.Genero;
import com.api.cuentas.domain.model.usuario.gateway.ClienteGateway;
import com.api.cuentas.domain.model.usuario.gateway.GeneroGateway;
import com.api.cuentas.infrastructure.jpa.entities.ClienteEntity;
import com.api.cuentas.infrastructure.jpa.entities.GeneroEntity;
import com.api.cuentas.infrastructure.jpa.helper.AdapterOperations;
import com.api.cuentas.infrastructure.jpa.repository.ClienteRepository;
import com.api.cuentas.infrastructure.jpa.repository.GeneroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;


@Repository
class ClienteRepositoryAdapter extends AdapterOperations<Cliente, ClienteEntity, Integer, ClienteRepository>
      implements ClienteGateway {

    public ClienteRepositoryAdapter(ClienteRepository repository, ModelMapper mapper) {
        super(repository, mapper, ClienteEntity.class, e -> mapper.map(e, Cliente.class));
    }

}
