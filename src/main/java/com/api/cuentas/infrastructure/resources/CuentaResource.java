package com.api.cuentas.infrastructure.resources;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;

public interface CuentaResource {

    @Operation(summary = "Obtiene una cuenta")
    @GetMapping("/cuenta")
    Long obtenerCuenta();

}
