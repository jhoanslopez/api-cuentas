package com.api.cuentas.infrastructure.resources;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MensajeError {
    private String mensaje;
}
