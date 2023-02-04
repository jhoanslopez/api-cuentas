package com.api.cuentas.domain.model.cuenta.gateway;


import com.api.cuentas.domain.model.cuenta.TipoCuenta;

import java.util.List;

public interface TipoCuentaGateway {

    List<TipoCuenta> findAll();

    TipoCuenta findById(Integer id);

    TipoCuenta findByCode(String code);

}
