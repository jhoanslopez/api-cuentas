package com.api.cuentas.domain.usecase;

import com.api.cuentas.domain.model.usuario.Genero;
import com.api.cuentas.domain.model.usuario.TipoIdentificacion;
import com.api.cuentas.domain.model.usuario.gateway.GeneroGateway;
import com.api.cuentas.domain.model.usuario.gateway.TipoIdentificacionGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TipoIdentificacionUseCase {

    private final TipoIdentificacionGateway tipoIdentificacionGateway;

    public List<TipoIdentificacion> obtenerTipoIdentificaciones() {
        return tipoIdentificacionGateway.findAll();
    }

    public TipoIdentificacion obtenerTipoIdentificacion(Integer id) {
        return tipoIdentificacionGateway.findById(id);
    }

    public TipoIdentificacion obtenerTipoIdentificacion(String codigo) {
        return tipoIdentificacionGateway.findByCode(codigo);
    }

}
