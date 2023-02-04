package com.api.cuentas.domain.model.movimiento.gateway;


import com.api.cuentas.domain.model.cuenta.TipoCuenta;
import com.api.cuentas.domain.model.movimiento.TipoMovimiento;

import java.util.List;

public interface TipoMovimientoGateway {

    List<TipoMovimiento> findAll();

    TipoMovimiento findById(Integer id);

    TipoMovimiento findByCode(String code);

}
