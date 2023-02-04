package com.api.cuentas.infrastructure.jpa.adapter;

import com.api.cuentas.domain.model.cuenta.Cuenta;
import com.api.cuentas.domain.model.cuenta.gateway.CuentaGateway;
import com.api.cuentas.infrastructure.jpa.entities.CuentaEntity;
import com.api.cuentas.infrastructure.jpa.helper.AdapterOperations;
import com.api.cuentas.infrastructure.jpa.repository.CuentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;


@Repository
class CuentaRepositoryAdapter extends AdapterOperations<Cuenta, CuentaEntity, Integer, CuentaRepository>
      implements CuentaGateway {

    public CuentaRepositoryAdapter(CuentaRepository repository, ModelMapper mapper) {
        super(repository, mapper, CuentaEntity.class, e -> mapper.map(e, Cuenta.class));
    }

    @Override
    public Cuenta findByNumeroCuenta(Long numeroCuenta) {
        return this.toModel(repository.findByNumeroCuenta(numeroCuenta));
    }
}
