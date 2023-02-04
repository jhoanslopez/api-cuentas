package com.api.cuentas.infrastructure.resources.impl;

import com.api.cuentas.domain.model.cuenta.Cuenta;
import com.api.cuentas.domain.model.cuenta.CuentaActualizar;
import com.api.cuentas.domain.model.cuenta.CuentaCliente;
import com.api.cuentas.domain.usecase.CuentaUseCase;
import com.api.cuentas.domain.usecase.exception.LogicaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class CuentaResourceImplTest {

    @InjectMocks
    private CuentaResourceImpl cuentaResource;

    @Mock
    private CuentaUseCase cuentaUseCase;

    @BeforeEach
    void setup() throws LogicaException {

        MockitoAnnotations.openMocks(this);
        CuentaCliente cuentaCliente = CuentaCliente.builder()
                .idCuenta(1)
                .numeroCuenta(123L)
                .estado(true)
                .build();

        when(cuentaUseCase.obtenerCuentas()).thenReturn(Collections.singletonList(cuentaCliente));
        when(cuentaUseCase.obtenerCuenta(anyInt())).thenReturn(cuentaCliente);
        when(cuentaUseCase.crearCuenta(any())).thenReturn(cuentaCliente);
        when(cuentaUseCase.actualizarCuenta(any())).thenReturn(cuentaCliente);
        when(cuentaUseCase.eliminarCuenta(anyInt())).thenReturn(true);
    }

    @Test
    void obtenerCuentas() {
        ResponseEntity<List<CuentaCliente>> response = cuentaResource.obtenerCuentas();
        assertFalse(CollectionUtils.isEmpty(response.getBody()));
    }

    @Test
    void obtenerCuenta() {
        ResponseEntity<CuentaCliente> response = cuentaResource.obtenerCuenta(1);
        assertTrue(Objects.nonNull(response.getBody()));
    }

    @Test
    void crearCuenta() {
        ResponseEntity<CuentaCliente> response = cuentaResource.crearCuenta(new Cuenta());
        assertTrue(Objects.nonNull(response.getBody()));
    }

    @Test
    void actualizarCuenta() {
        ResponseEntity<CuentaCliente> response = cuentaResource.actualizarCuenta(new CuentaActualizar());
        assertTrue(Objects.nonNull(response.getBody()));
    }

    @Test
    void eliminarCuenta() {
        ResponseEntity<Boolean> response = cuentaResource.eliminarCuenta(1);
        assertEquals(Boolean.TRUE, response.getBody());
    }
}