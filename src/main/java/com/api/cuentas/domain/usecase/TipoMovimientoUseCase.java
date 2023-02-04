package com.api.cuentas.domain.usecase;

import com.api.cuentas.domain.model.movimiento.TipoMovimiento;
import com.api.cuentas.domain.model.movimiento.gateway.TipoMovimientoGateway;
import com.api.cuentas.domain.model.usuario.TipoIdentificacion;
import com.api.cuentas.domain.model.usuario.gateway.TipoIdentificacionGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TipoMovimientoUseCase {

    private final TipoMovimientoGateway tipoMovimientoGateway;

    public List<TipoMovimiento> obtenerTipoMovimientos() {
        return tipoMovimientoGateway.findAll();
    }

    public TipoMovimiento obtenerTipoMovimiento(Integer id) {
        return tipoMovimientoGateway.findById(id);
    }

    public TipoMovimiento obtenerTipoMovimiento(String codigo) {
        return tipoMovimientoGateway.findByCode(codigo);
    }

}
