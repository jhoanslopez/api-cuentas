package com.api.cuentas.domain.model.cuenta;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoCuenta {
    private Integer id;
    private String codigo;
    private String descripcion;
}
