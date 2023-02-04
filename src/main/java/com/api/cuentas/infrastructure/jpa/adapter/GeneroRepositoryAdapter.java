package com.api.cuentas.infrastructure.jpa.adapter;

import com.api.cuentas.domain.model.usuario.Genero;
import com.api.cuentas.domain.model.usuario.gateway.GeneroGateway;
import com.api.cuentas.infrastructure.jpa.entities.GeneroEntity;
import com.api.cuentas.infrastructure.jpa.helper.AdapterOperations;
import com.api.cuentas.infrastructure.jpa.repository.GeneroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;


@Repository
class GeneroRepositoryAdapter extends AdapterOperations<Genero, GeneroEntity, Integer, GeneroRepository>
      implements GeneroGateway {

    public GeneroRepositoryAdapter(GeneroRepository repository, ModelMapper mapper) {
        super(repository, mapper, GeneroEntity.class, e -> mapper.map(e, Genero.class));
    }

    @Override
    public Genero findByCode(String code) {
        return toModel(repository.findByCodigo(code));
    }
}
