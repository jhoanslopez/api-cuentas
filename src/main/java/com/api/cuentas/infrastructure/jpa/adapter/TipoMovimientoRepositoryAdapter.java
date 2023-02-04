package com.api.cuentas.infrastructure.jpa.adapter;

import com.api.cuentas.domain.model.movimiento.TipoMovimiento;
import com.api.cuentas.domain.model.movimiento.gateway.TipoMovimientoGateway;
import com.api.cuentas.infrastructure.jpa.entities.TipoMovimientoEntity;
import com.api.cuentas.infrastructure.jpa.helper.AdapterOperations;
import com.api.cuentas.infrastructure.jpa.repository.TipoMovimientoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;


@Repository
class TipoMovimientoRepositoryAdapter extends AdapterOperations<TipoMovimiento, TipoMovimientoEntity, Integer, TipoMovimientoRepository>
      implements TipoMovimientoGateway {

    public TipoMovimientoRepositoryAdapter(TipoMovimientoRepository repository, ModelMapper mapper) {
        super(repository, mapper, TipoMovimientoEntity.class, e -> mapper.map(e, TipoMovimiento.class));
    }

    @Override
    public TipoMovimiento findByCode(String code) {
        return toModel(repository.findByCodigo(code));
    }
}
