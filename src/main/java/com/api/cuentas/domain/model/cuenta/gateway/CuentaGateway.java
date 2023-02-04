package com.api.cuentas.domain.model.cuenta.gateway;


import com.api.cuentas.domain.model.cuenta.Cuenta;

import java.util.List;

public interface CuentaGateway {

    List<Cuenta> findAll();

    Cuenta findById(Integer id);

    Cuenta findByNumeroCuenta(Long numeroCuenta);

    Cuenta save(Cuenta cliente);

    void deleteById(Integer id);

}
