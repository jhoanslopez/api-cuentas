package com.api.cuentas.domain.model.movimiento;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoCuenta {
    private Integer id;
    private Long numeroCuenta;
    private String codigoTipoCuenta;
    private String tipoCuenta;
    private String codigoTipoMovimiento;
    private String tipoMovimiento;
    private String nombreCliente;
    private Long saldoInicial;
    private Long valorMovimiento;
    private Long saldoDisponible;
    private Date fecha;
}
