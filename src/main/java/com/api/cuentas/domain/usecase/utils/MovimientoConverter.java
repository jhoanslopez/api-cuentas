package com.api.cuentas.domain.usecase.utils;

import com.api.cuentas.domain.model.cuenta.Cuenta;
import com.api.cuentas.domain.model.cuenta.CuentaActualizar;
import com.api.cuentas.domain.model.cuenta.CuentaCliente;
import com.api.cuentas.domain.model.movimiento.Movimiento;
import com.api.cuentas.domain.model.movimiento.MovimientoCuenta;
import com.api.cuentas.domain.model.usuario.Cliente;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MovimientoConverter {

    public static List<MovimientoCuenta> toMovimientoCuenta(List<Movimiento> movimientos) {
        List<MovimientoCuenta> movimientosCuenta = null;
        if (!CollectionUtils.isEmpty(movimientos)) {
            movimientosCuenta = movimientos.stream()
                    .map(MovimientoConverter::toMovimientoCuenta)
                    .toList();
        }
        return movimientosCuenta;
    }

    public static MovimientoCuenta toMovimientoCuenta(Movimiento movimiento) {
        return MovimientoCuenta.builder()
                .id(movimiento.getId())
                .numeroCuenta(movimiento.getCuenta().getNumeroCuenta())
                .codigoTipoCuenta(movimiento.getCuenta().getTipoCuenta().getCodigo())
                .tipoCuenta(movimiento.getCuenta().getTipoCuenta().getDescripcion())
                .codigoTipoMovimiento(movimiento.getTipoMovimiento().getCodigo())
                .tipoMovimiento(movimiento.getTipoMovimiento().getDescripcion())
                .nombreCliente(movimiento.getCliente().getPersona().getNombre())
                .saldoInicial(movimiento.getSaldoInicial())
                .valorMovimiento(movimiento.getValorMovimiento())
                .saldoDisponible(movimiento.getSaldoDisponible())
                .fecha(movimiento.getFecha())
                .build();
    }
}
