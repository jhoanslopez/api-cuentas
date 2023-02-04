package com.api.cuentas.infrastructure.resources.impl;

import com.api.cuentas.domain.model.movimiento.MovimientoCuenta;
import com.api.cuentas.domain.model.movimiento.MovimientoGenerar;
import com.api.cuentas.domain.model.usuario.Usuario;
import com.api.cuentas.domain.usecase.MovimientoUseCase;
import com.api.cuentas.domain.usecase.PersonaUseCase;
import com.api.cuentas.domain.usecase.exception.LogicaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class MovimientoResourceImplTest {

    @InjectMocks
    private MovimientoResourceImpl movimientoResource;

    @Mock
    private MovimientoUseCase movimientoUseCase;

    @BeforeEach
    void setup() throws LogicaException {

        MockitoAnnotations.openMocks(this);
        MovimientoCuenta movimientoCuenta = MovimientoCuenta.builder()
                .fecha(new Date())
                .valorMovimiento(10L)
                .numeroCuenta(293L)
                .saldoInicial(10L)
                .saldoDisponible(20L)
                .build();

        when(movimientoUseCase.obtenerMovimientos()).thenReturn(Collections.singletonList(movimientoCuenta));
        when(movimientoUseCase.obtenerMovimiento(anyInt())).thenReturn(movimientoCuenta);
        when(movimientoUseCase.generarMovimiento(any())).thenReturn(movimientoCuenta);
    }

    @Test
    void obtenerMovimientos() {
        ResponseEntity<List<MovimientoCuenta>> response = movimientoResource.obtenerMovimientos();
        assertFalse(CollectionUtils.isEmpty(response.getBody()));
    }

    @Test
    void obtenerMovimiento() {
        ResponseEntity<MovimientoCuenta> response = movimientoResource.obtenerMovimiento(1);
        assertTrue(Objects.nonNull(response.getBody()));
    }

    @Test
    void generarMovimiento() {
        ResponseEntity<MovimientoCuenta> response = movimientoResource
                .generarMovimiento(MovimientoGenerar.builder()
                        .valorMovimiento(10L)
                        .idCliente(1)
                        .numeroCuenta(2132L)
                        .build());
        assertTrue(Objects.nonNull(response.getBody()));
    }
}