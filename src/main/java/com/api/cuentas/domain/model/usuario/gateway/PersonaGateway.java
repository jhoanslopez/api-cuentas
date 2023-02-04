package com.api.cuentas.domain.model.usuario.gateway;


import com.api.cuentas.domain.model.usuario.Persona;

import java.util.List;

public interface PersonaGateway {

    List<Persona> findAll();

    Persona findById(Integer id);

    Persona save(Persona persona);

    void deleteById(Integer id);

}
