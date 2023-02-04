package com.api.cuentas.infrastructure.jpa.adapter;

import com.api.cuentas.domain.model.cuenta.TipoCuenta;
import com.api.cuentas.domain.model.cuenta.gateway.TipoCuentaGateway;
import com.api.cuentas.domain.model.usuario.Genero;
import com.api.cuentas.domain.model.usuario.gateway.GeneroGateway;
import com.api.cuentas.infrastructure.jpa.entities.GeneroEntity;
import com.api.cuentas.infrastructure.jpa.entities.TipoCuentaEntity;
import com.api.cuentas.infrastructure.jpa.helper.AdapterOperations;
import com.api.cuentas.infrastructure.jpa.repository.GeneroRepository;
import com.api.cuentas.infrastructure.jpa.repository.TipoCuentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;


@Repository
class TipoCuentaRepositoryAdapter extends AdapterOperations<TipoCuenta, TipoCuentaEntity, Integer, TipoCuentaRepository>
      implements TipoCuentaGateway {

    public TipoCuentaRepositoryAdapter(TipoCuentaRepository repository, ModelMapper mapper) {
        super(repository, mapper, TipoCuentaEntity.class, e -> mapper.map(e, TipoCuenta.class));
    }

    @Override
    public TipoCuenta findByCode(String code) {
        return toModel(repository.findByCodigo(code));
    }
}
