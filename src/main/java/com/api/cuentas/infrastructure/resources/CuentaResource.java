package com.api.cuentas.infrastructure.resources;

import com.api.cuentas.domain.model.cuenta.Cuenta;
import com.api.cuentas.domain.model.cuenta.CuentaActualizar;
import com.api.cuentas.domain.model.cuenta.CuentaCliente;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CuentaResource {

    @Operation(summary = "Obtiene todos las cuentas")
    @GetMapping("/cuentas")
    ResponseEntity<List<CuentaCliente>> obtenerCuentas();

    @Operation(summary = "Obtiene un cuenta por su id")
    @GetMapping("/cuenta/{id}")
    ResponseEntity<CuentaCliente> obtenerCuenta(@PathVariable("id") Integer id);

    @Operation(summary = "Crea un nuevo cuenta")
    @PostMapping("/cuenta")
    ResponseEntity<CuentaCliente> crearCuenta(@RequestBody Cuenta cuenta);

    @Operation(summary = "Actualiza un cuenta")
    @PutMapping("/cuenta")
    ResponseEntity<CuentaCliente> actualizarCuenta(@RequestBody CuentaActualizar cuentaActualizar);

    @Operation(summary = "Elimina un cuenta por su id")
    @DeleteMapping("/cuenta/{id}")
    ResponseEntity<Boolean> eliminarCuenta(@PathVariable("id") Integer id);

}
