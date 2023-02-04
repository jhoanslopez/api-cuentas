package com.api.cuentas.domain.model.cuenta;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaActualizar {
    private Integer id;
    private Long numeroCuenta;
    private String codigoTipoCuenta;
    private Boolean estado;
}
