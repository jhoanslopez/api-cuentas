package com.api.cuentas.infrastructure.jpa.adapter;

import com.api.cuentas.domain.model.usuario.Genero;
import com.api.cuentas.domain.model.usuario.TipoIdentificacion;
import com.api.cuentas.domain.model.usuario.gateway.TipoIdentificacionGateway;
import com.api.cuentas.infrastructure.jpa.entities.TipoIdentificacionEntity;
import com.api.cuentas.infrastructure.jpa.helper.AdapterOperations;
import com.api.cuentas.infrastructure.jpa.repository.TipoIdentificacionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;


@Repository
class TipoIdentificacionRepositoryAdapter extends AdapterOperations<TipoIdentificacion, TipoIdentificacionEntity, Integer, TipoIdentificacionRepository>
      implements TipoIdentificacionGateway {

    public TipoIdentificacionRepositoryAdapter(TipoIdentificacionRepository repository, ModelMapper mapper) {
        super(repository, mapper, TipoIdentificacionEntity.class, e -> mapper.map(e, TipoIdentificacion.class));
    }

    @Override
    public TipoIdentificacion findByCode(String code) {
        return toModel(repository.findByCodigo(code));
    }
}
