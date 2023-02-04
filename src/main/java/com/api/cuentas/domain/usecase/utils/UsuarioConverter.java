package com.api.cuentas.domain.usecase.utils;

import com.api.cuentas.domain.model.usuario.Cliente;
import com.api.cuentas.domain.model.usuario.Persona;
import com.api.cuentas.domain.model.usuario.Usuario;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioConverter {

    public static List<Usuario> toUsuario(List<Cliente> clientes) {
        List<Usuario> usuarios = null;
        if (!CollectionUtils.isEmpty(clientes)) {
            usuarios = clientes.stream()
                    .map(cliente -> toUsuario(cliente.getPersona(), cliente))
                    .toList();
        }
        return usuarios;
    }

    public static Usuario toUsuario(Cliente cliente) {
        return toUsuario(cliente.getPersona(), cliente);
    }

    public static Usuario toUsuario(Persona persona, Cliente cliente) {
        return Usuario.builder()
                .idCliente(cliente.getId())
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

    public static Cliente mapper(Cliente clienteOriginal, Usuario usuario) {
        clienteOriginal.setContrasena(usuario.getContrasena());
        clienteOriginal.setEstado(usuario.getEstado());
        clienteOriginal.setPersona(mapper(clienteOriginal.getPersona(), usuario));
        return clienteOriginal;
    }

    public static Persona mapper(Persona personaOriginal, Usuario usuario) {
        personaOriginal.setNombre(usuario.getNombres());
        personaOriginal.setDireccion(usuario.getDireccion());
        personaOriginal.setEdad(usuario.getEdad());
        personaOriginal.setTelefono(usuario.getTelefono());
        personaOriginal.setDireccion(usuario.getDireccion());
        return personaOriginal;
    }

}
