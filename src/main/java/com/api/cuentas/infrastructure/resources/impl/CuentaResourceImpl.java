package com.api.cuentas.infrastructure.resources.impl;

import com.api.cuentas.infrastructure.resources.CuentaResource;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CuentaResourceImpl implements CuentaResource {

    @Override
    public Long obtenerCuenta() {
        return 1L;
    }
}
