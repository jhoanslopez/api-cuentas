package com.api.cuentas.domain.model.usuario;

import com.api.cuentas.infrastructure.jpa.entities.PersonaEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private Integer id;

    private String contrasena;

    private Boolean estado;

    private Persona persona;
}
