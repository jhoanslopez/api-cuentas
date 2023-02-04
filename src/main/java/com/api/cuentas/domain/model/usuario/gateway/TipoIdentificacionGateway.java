package com.api.cuentas.domain.model.usuario.gateway;


import com.api.cuentas.domain.model.usuario.TipoIdentificacion;

import java.util.List;

public interface TipoIdentificacionGateway {

    List<TipoIdentificacion> findAll();

    TipoIdentificacion findById(Integer id);

    TipoIdentificacion findByCode(String code);

}
