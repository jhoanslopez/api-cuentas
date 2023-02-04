package com.api.cuentas.domain.model.movimiento;

import com.api.cuentas.domain.model.cuenta.Cuenta;
import com.api.cuentas.domain.model.usuario.Cliente;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movimiento {
    private Integer id;
    private Cuenta cuenta;
    private TipoMovimiento tipoMovimiento;
    private Cliente cliente;
    private Long saldoInicial;
    private Long valorMovimiento;
    private Long saldoDisponible;
    private Date fecha;
}
