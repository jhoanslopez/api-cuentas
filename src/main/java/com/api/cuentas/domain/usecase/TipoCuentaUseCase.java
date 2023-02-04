package com.api.cuentas.domain.usecase;

import com.api.cuentas.domain.model.cuenta.TipoCuenta;
import com.api.cuentas.domain.model.cuenta.gateway.TipoCuentaGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TipoCuentaUseCase {

    private final TipoCuentaGateway tipoCuentaGateway;

    public List<TipoCuenta> obtenerTipoCuentas() {
        return tipoCuentaGateway.findAll();
    }

    public TipoCuenta obtenerTipoCuenta(Integer id) {
        return tipoCuentaGateway.findById(id);
    }

    public TipoCuenta obtenerTipoCuenta(String codigo) {
        return tipoCuentaGateway.findByCode(codigo);
    }

}
