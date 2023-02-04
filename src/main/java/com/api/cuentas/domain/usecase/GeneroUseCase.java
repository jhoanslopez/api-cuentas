package com.api.cuentas.domain.usecase;

import com.api.cuentas.domain.model.usuario.Genero;
import com.api.cuentas.domain.model.usuario.Persona;
import com.api.cuentas.domain.model.usuario.gateway.GeneroGateway;
import com.api.cuentas.domain.model.usuario.gateway.PersonaGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GeneroUseCase {

    private final GeneroGateway generoGateway;

    public List<Genero> obtenerGeneros() {
        return generoGateway.findAll();
    }

    public Genero obtenerGenero(Integer id) {
        return generoGateway.findById(id);
    }

    public Genero obtenerGenero(String codigo) {
        Genero genero = generoGateway.findByCode(codigo);
        return genero;
    }

}
