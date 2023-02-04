package com.api.cuentas.domain.model.movimiento;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoMovimiento {
    private Integer id;
    private String codigo;
    private String descripcion;
}
