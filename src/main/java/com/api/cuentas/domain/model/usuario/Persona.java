package com.api.cuentas.domain.model.usuario;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private Integer id;
    private String nombre;
    private Genero genero;
    private Short edad;
    private TipoIdentificacion tipoIdentificacion;
    private String direccion;
    private String telefono;
}
