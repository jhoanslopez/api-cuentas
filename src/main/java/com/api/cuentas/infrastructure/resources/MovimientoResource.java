package com.api.cuentas.infrastructure.resources;

import com.api.cuentas.domain.model.cuenta.Cuenta;
import com.api.cuentas.domain.model.cuenta.CuentaActualizar;
import com.api.cuentas.domain.model.cuenta.CuentaCliente;
import com.api.cuentas.domain.model.movimiento.Movimiento;
import com.api.cuentas.domain.model.movimiento.MovimientoCuenta;
import com.api.cuentas.domain.model.movimiento.MovimientoGenerar;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MovimientoResource {

    @Operation(summary = "Obtiene todos los movimientos")
    @GetMapping("/movimientos")
    ResponseEntity<List<MovimientoCuenta>> obtenerMovimientos();

    @Operation(summary = "Obtiene un movimiento por su id")
    @GetMapping("/movimiento/{id}")
    ResponseEntity<MovimientoCuenta> obtenerMovimiento(@PathVariable("id") Integer id);

    @Operation(summary = "Genera un nuevo movimiento de la cuenta")
    @PostMapping("/movimiento")
    ResponseEntity<MovimientoCuenta> generarMovimiento(@RequestBody MovimientoGenerar movimientoGenerar);

}
