package com.api.cuentas.domain.model.usuario;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String nombres;
    private String codigoGenero;
    private String genero;
    private String codigoTipoIdentificacion;
    private String tipoIdentificacion;
    private Short edad;
    private String direccion;
    private String telefono;
    private String contrasena;
    private Boolean estado;
}
