package com.api.cuentas.domain.model.cuenta;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaCliente {
    private Integer idCuenta;
    private Integer idCliente;
    private String nombreCliente;
    private Long numeroCuenta;
    private String codigoTipoCuenta;
    private String tipoCuenta;
    private Long saldo;
    private Boolean estado;
}
