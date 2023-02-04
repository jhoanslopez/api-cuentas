package com.api.cuentas.domain.model.movimiento.gateway;


import com.api.cuentas.domain.model.cuenta.Cuenta;
import com.api.cuentas.domain.model.movimiento.Movimiento;
import com.api.cuentas.domain.model.movimiento.TipoMovimiento;

import java.util.List;

public interface MovimientoGateway {

    List<Movimiento> findAll();

    Movimiento findById(Integer id);

    Movimiento save(Movimiento movimiento);

}
