package com.api.cuentas.infrastructure.jpa.adapter;

import com.api.cuentas.domain.model.movimiento.Movimiento;
import com.api.cuentas.domain.model.movimiento.TipoMovimiento;
import com.api.cuentas.domain.model.movimiento.gateway.MovimientoGateway;
import com.api.cuentas.domain.model.movimiento.gateway.TipoMovimientoGateway;
import com.api.cuentas.infrastructure.jpa.entities.MovimientoEntity;
import com.api.cuentas.infrastructure.jpa.entities.TipoMovimientoEntity;
import com.api.cuentas.infrastructure.jpa.helper.AdapterOperations;
import com.api.cuentas.infrastructure.jpa.repository.MovimientoRepository;
import com.api.cuentas.infrastructure.jpa.repository.TipoMovimientoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;


@Repository
class MovimientoRepositoryAdapter extends AdapterOperations<Movimiento, MovimientoEntity, Integer, MovimientoRepository>
      implements MovimientoGateway {

    public MovimientoRepositoryAdapter(MovimientoRepository repository, ModelMapper mapper) {
        super(repository, mapper, MovimientoEntity.class, e -> mapper.map(e, Movimiento.class));
    }
}
