package com.api.cuentas.domain.model.usuario;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoIdentificacion {
    private Integer id;
    private String codigo;
    private String descripcion;
}
