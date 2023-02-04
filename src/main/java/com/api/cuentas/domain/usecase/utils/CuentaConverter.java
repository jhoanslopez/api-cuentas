package com.api.cuentas.domain.usecase.utils;

import com.api.cuentas.domain.model.cuenta.Cuenta;
import com.api.cuentas.domain.model.cuenta.CuentaActualizar;
import com.api.cuentas.domain.model.cuenta.CuentaCliente;
import com.api.cuentas.domain.model.usuario.Cliente;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CuentaConverter {


    public static List<CuentaCliente> toCuentaCliente(List<Cuenta> cuentas) {
        List<CuentaCliente> cuentasCliente = null;
        if (!CollectionUtils.isEmpty(cuentas)) {
            cuentasCliente = cuentas.stream()
                    .map(CuentaConverter::toCuentaCliente)
                    .toList();
        }
        return cuentasCliente;
    }

    public static CuentaCliente toCuentaCliente(Cuenta cuenta) {
        CuentaCliente cuentaCliente = CuentaCliente.builder()
                .idCuenta(cuenta.getId())
                .numeroCuenta(cuenta.getNumeroCuenta())
                .codigoTipoCuenta(cuenta.getTipoCuenta().getCodigo())
                .tipoCuenta(cuenta.getTipoCuenta().getDescripcion())
                .saldo(cuenta.getSaldo())
                .estado(cuenta.getEstado())
                .build();
        setDatosCliente(cuentaCliente, cuenta);
        return  cuentaCliente;
    }

    public static void setDatosCliente(CuentaCliente cuentaCliente, Cuenta cuenta){
        if(!CollectionUtils.isEmpty(cuenta.getClientes())){
            Cliente cliente = cuenta.getClientes().get(0);
            cuentaCliente.setIdCliente(cliente.getId());
            cuentaCliente.setNombreCliente(cliente.getPersona().getNombre());
        }
    }

    public static Cuenta mapper(Cuenta cuentaOriginal, CuentaActualizar cuentaActualizar) {
        cuentaOriginal.setNumeroCuenta(cuentaActualizar.getNumeroCuenta());
        cuentaOriginal.setEstado(cuentaActualizar.getEstado());
        return cuentaOriginal;
    }
}
