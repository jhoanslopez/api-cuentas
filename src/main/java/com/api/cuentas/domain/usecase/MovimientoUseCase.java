package com.api.cuentas.domain.usecase;

import com.api.cuentas.domain.model.cuenta.Cuenta;
import com.api.cuentas.domain.model.cuenta.gateway.CuentaGateway;
import com.api.cuentas.domain.model.movimiento.Movimiento;
import com.api.cuentas.domain.model.movimiento.MovimientoCuenta;
import com.api.cuentas.domain.model.movimiento.MovimientoGenerar;
import com.api.cuentas.domain.model.movimiento.TipoMovimiento;
import com.api.cuentas.domain.model.movimiento.gateway.MovimientoGateway;
import com.api.cuentas.domain.model.usuario.Cliente;
import com.api.cuentas.domain.usecase.exception.CodigoNoEncontradoException;
import com.api.cuentas.domain.usecase.exception.LogicaException;
import com.api.cuentas.domain.usecase.exception.ValidacionException;
import com.api.cuentas.domain.usecase.utils.MovimientoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MovimientoUseCase {


    private final MovimientoGateway movimientoGateway;
    private final CuentaGateway cuentaGateway;
    private final ClienteUseCase clienteUseCase;
    private final CuentaUseCase cuentaUseCase;
    private final TipoMovimientoUseCase tipoMovimientoUseCase;

    private static final String DEBITO_CODE = "DEB";
    private static final String CREDITO_CODE = "CRE";
    private static final String SALDO_UNAVAILABLE = "Saldo no disponible";

    @Transactional
    public List<MovimientoCuenta> obtenerMovimientos() throws LogicaException {
        List<MovimientoCuenta> response;
        try {
            response = MovimientoConverter.toMovimientoCuenta(movimientoGateway.findAll());
        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    @Transactional
    public MovimientoCuenta obtenerMovimiento(Integer id) throws LogicaException {
        MovimientoCuenta response;
        try {
            Movimiento movimiento = Optional.ofNullable(movimientoGateway.findById(id))
                    .orElseThrow(() -> new CodigoNoEncontradoException(id.toString()));
            response = MovimientoConverter.toMovimientoCuenta(movimiento);
        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    @Transactional
    public MovimientoCuenta generarMovimiento(MovimientoGenerar movimientoGenerar) throws LogicaException {
        MovimientoCuenta response ;
        try {
            Movimiento movimiento = buildMovimiento(movimientoGenerar);
            movimiento.setSaldoInicial(movimiento.getCuenta().getSaldo());
            movimiento.setSaldoDisponible(calcularSaldoDisponible(movimiento));
            movimiento.setFecha(new Date());
            movimiento = movimientoGateway.save(movimiento);

            Cuenta cuenta = movimiento.getCuenta();
            cuenta.setSaldo(movimiento.getSaldoDisponible());
            cuentaGateway.save(cuenta);

            response = MovimientoConverter.toMovimientoCuenta(movimiento);

        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    private Long calcularSaldoDisponible(Movimiento movimiento) throws ValidacionException {
        long saldoDisponible = movimiento.getCuenta().getSaldo() + movimiento.getValorMovimiento();
        if(saldoDisponible < 0) {
            throw new ValidacionException(SALDO_UNAVAILABLE);
        }
        return saldoDisponible;
    }

    private TipoMovimiento validarTipoMovimiento(Long valor) throws CodigoNoEncontradoException, ValidacionException {
        TipoMovimiento tipoMovimiento;
        if(valor > 0) {
            tipoMovimiento = obtenerTipoMovimiento(CREDITO_CODE);
        }else if(valor < 0){
            tipoMovimiento = obtenerTipoMovimiento(DEBITO_CODE);
        }else{
            throw new ValidacionException(SALDO_UNAVAILABLE);
        }
        return tipoMovimiento;
    }
    private TipoMovimiento obtenerTipoMovimiento(String codigo) throws CodigoNoEncontradoException {
        return Optional.ofNullable(tipoMovimientoUseCase.obtenerTipoMovimiento(codigo))
                .orElseThrow(() -> new CodigoNoEncontradoException(codigo));
    }
    private Cliente obtenerCliente(Integer id) throws CodigoNoEncontradoException {
        return Optional.ofNullable(clienteUseCase.obtenerCliente(id))
                .orElseThrow(() -> new CodigoNoEncontradoException(id.toString()));
    }

    private Movimiento buildMovimiento(MovimientoGenerar movimientoGenerar) throws LogicaException {
        return Movimiento.builder()
                .cliente(obtenerCliente(movimientoGenerar.getIdCliente()))
                .cuenta(cuentaUseCase.obtenerCuentaPorNumeroCuenta(movimientoGenerar.getNumeroCuenta()))
                .valorMovimiento(movimientoGenerar.getValorMovimiento())
                .tipoMovimiento(validarTipoMovimiento(movimientoGenerar.getValorMovimiento()))
                .build();
    }

}
