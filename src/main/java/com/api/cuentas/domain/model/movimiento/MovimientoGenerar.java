package com.api.cuentas.domain.model.movimiento;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoGenerar {
    private Integer idCliente;
    private Long numeroCuenta;
    private Long valorMovimiento;
}
