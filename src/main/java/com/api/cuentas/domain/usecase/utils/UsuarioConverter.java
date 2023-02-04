package com.api.cuentas.domain.usecase.utils;

import com.api.cuentas.domain.model.usuario.Cliente;
import com.api.cuentas.domain.model.usuario.Persona;
import com.api.cuentas.domain.model.usuario.Usuario;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioConverter {

    public static Usuario toUsuario(Persona persona, Cliente cliente) {
        return Usuario.builder()
                .nombres(persona.getNombre())
                .codigoGenero(persona.getGenero().getCodigo())
                .genero(persona.getGenero().getDescripcion())
                .codigoTipoIdentificacion(persona.getTipoIdentificacion().getCodigo())
                .tipoIdentificacion(persona.getTipoIdentificacion().getDescripcion())
                .edad(persona.getEdad())
                .direccion(persona.getDireccion())
                .telefono(persona.getTelefono())
                .estado(cliente.getEstado())
                .contrasena(cliente.getContrasena())
                .build();
    }

}
