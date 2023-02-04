package com.api.cuentas.infrastructure.entrypoints;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;

public interface ApiCuenta {

    @Operation(summary = "Obtiene una cuenta")
    @GetMapping("/cuenta")
    Long obtenerCuenta();

}
