package com.api.cuentas.domain.usecase;

import com.api.cuentas.domain.model.cuenta.Cuenta;
import com.api.cuentas.domain.model.cuenta.CuentaActualizar;
import com.api.cuentas.domain.model.cuenta.CuentaCliente;
import com.api.cuentas.domain.model.cuenta.TipoCuenta;
import com.api.cuentas.domain.model.cuenta.gateway.CuentaGateway;
import com.api.cuentas.domain.model.usuario.*;
import com.api.cuentas.domain.usecase.exception.CodigoNoEncontradoException;
import com.api.cuentas.domain.usecase.exception.LogicaException;
import com.api.cuentas.domain.usecase.exception.ValidacionException;
import com.api.cuentas.domain.usecase.utils.CuentaConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CuentaUseCase {

    private final CuentaGateway cuentaGateway;
    private final TipoCuentaUseCase tipoCuentaUseCase;
    private final ClienteUseCase clienteUseCase;
    private final TipoIdentificacionUseCase tipoIdentificacionUseCase;

    @Transactional
    public List<CuentaCliente> obtenerCuentas() throws LogicaException {
        List<CuentaCliente> response;
        try {
            response = CuentaConverter.toCuentaCliente(cuentaGateway.findAll());
        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    @Transactional
    public CuentaCliente obtenerCuenta(Integer id) throws LogicaException {
        CuentaCliente response;
        try {
            Cuenta cuenta = Optional.ofNullable(cuentaGateway.findById(id))
                    .orElseThrow(() -> new CodigoNoEncontradoException(id.toString()));

            response = CuentaConverter.toCuentaCliente(cuenta);
        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    @Transactional
    public Cuenta obtenerCuentaPorNumeroCuenta(Long numeroCuenta) throws LogicaException {
        Cuenta response;
        try {
            response = Optional.ofNullable(cuentaGateway.findByNumeroCuenta(numeroCuenta))
                    .orElseThrow(() -> new CodigoNoEncontradoException(numeroCuenta.toString()));
        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    @Transactional
    public CuentaCliente crearCuenta(Cuenta cuenta) throws LogicaException {
        CuentaCliente response ;
        try {

            Cuenta cuentaCrear = buildCuenta(cuenta);
            cuentaCrear = cuentaGateway.save(cuentaCrear);
            response = CuentaConverter.toCuentaCliente(cuentaCrear);

        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    @Transactional
    public CuentaCliente actualizarCuenta(CuentaActualizar cuentaActualizar) throws LogicaException {
        CuentaCliente response;
        try {

            Cuenta cuentaOriginal = Optional.ofNullable(cuentaGateway.findById(cuentaActualizar.getId()))
                    .orElseThrow(() -> new CodigoNoEncontradoException(cuentaActualizar.getId().toString()));
            Cuenta cuentaActualizado = CuentaConverter.mapper(cuentaOriginal, cuentaActualizar);

            cuentaActualizado.setTipoCuenta(
                    obtenerTipoCuenta(cuentaActualizar.getCodigoTipoCuenta())
            );

            cuentaActualizado = cuentaGateway.save(cuentaActualizado);
            response = CuentaConverter.toCuentaCliente(cuentaActualizado);;

        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    @Transactional
    public Boolean eliminarCuenta(Integer id) throws LogicaException {
        Boolean response = true;
        try {

           Cuenta clienteOriginal = Optional.ofNullable(cuentaGateway.findById(id))
                    .orElseThrow(() -> new CodigoNoEncontradoException(id.toString()));

            cuentaGateway.deleteById(clienteOriginal.getId());
        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    private Cliente obtenerCliente(Integer id) throws CodigoNoEncontradoException {
        return Optional.ofNullable(clienteUseCase.obtenerCliente(id))
                .orElseThrow(() -> new CodigoNoEncontradoException(id.toString()));
    }

    private TipoCuenta obtenerTipoCuenta(String codigo) throws CodigoNoEncontradoException {
        return Optional.ofNullable(tipoCuentaUseCase.obtenerTipoCuenta(codigo))
                .orElseThrow(() -> new CodigoNoEncontradoException(codigo));
    }

    private Cuenta buildCuenta(Cuenta cuenta) throws LogicaException {
        return Cuenta.builder()
                .numeroCuenta(obtenerNumeroCuenta(cuenta.getNumeroCuenta()))
                .tipoCuenta(obtenerTipoCuenta(cuenta.getTipoCuenta().getCodigo()))
                .saldo(cuenta.getSaldo())
                .estado(cuenta.getEstado())
                .clientes(Collections.singletonList(obtenerCliente(cuenta.getIdCliente())))
                .build();
    }

    private Long obtenerNumeroCuenta(Long numeroCuenta) throws ValidacionException {
        return Optional.ofNullable(numeroCuenta)
                .orElseThrow(() -> new ValidacionException("Número cuenta vacío o nulo"));
    }

}
