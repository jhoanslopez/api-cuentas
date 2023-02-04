package com.api.cuentas.infrastructure.entrypoints.impl;

import com.api.cuentas.infrastructure.entrypoints.ApiCuenta;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiCuentaImpl implements ApiCuenta {

    @Override
    public Long obtenerCuenta() {
        return 1L;
    }
}
