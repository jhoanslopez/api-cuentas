package com.api.cuentas.infrastructure.jpa.adapter;

import com.api.cuentas.domain.model.usuario.Persona;
import com.api.cuentas.domain.model.usuario.gateway.PersonaGateway;
import com.api.cuentas.infrastructure.jpa.entities.PersonaEntity;
import com.api.cuentas.infrastructure.jpa.helper.AdapterOperations;
import com.api.cuentas.infrastructure.jpa.repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;


@Repository
class PersonaRepositoryAdapter extends AdapterOperations<Persona, PersonaEntity, Integer, PersonaRepository>
      implements PersonaGateway {

    public PersonaRepositoryAdapter(PersonaRepository repository, ModelMapper mapper) {
        super(repository, mapper, PersonaEntity.class, e -> mapper.map(e, Persona.class));
    }

}
