package com.api.cuentas.domain.model.cuenta;

import com.api.cuentas.domain.model.usuario.Cliente;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {
    private Integer id;
    private Long numeroCuenta;
    private TipoCuenta tipoCuenta;
    private Long saldo;
    private Boolean estado;
    private Integer idCliente;
    private List<Cliente> clientes;
}
