package com.api.cuentas.domain.model.cuenta;

import com.api.cuentas.domain.model.usuario.Cliente;
import lombok.*;

import java.util.List;

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
