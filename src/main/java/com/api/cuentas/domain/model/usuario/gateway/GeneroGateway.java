package com.api.cuentas.domain.model.usuario.gateway;


import com.api.cuentas.domain.model.usuario.Genero;

import java.util.List;

public interface GeneroGateway {

    List<Genero> findAll();

    Genero findById(Integer id);

    Genero findByCode(String code);

}
