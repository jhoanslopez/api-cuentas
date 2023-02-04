package com.api.cuentas.domain.model.cuenta.gateway;


import com.api.cuentas.domain.model.cuenta.Cuenta;
import com.api.cuentas.domain.model.cuenta.TipoCuenta;
import com.api.cuentas.domain.model.usuario.Genero;

import java.util.List;

public interface TipoCuentaGateway {

    List<TipoCuenta> findAll();

    TipoCuenta findById(Integer id);

    TipoCuenta findByCode(String code);

}
