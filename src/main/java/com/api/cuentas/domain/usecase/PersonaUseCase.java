package com.api.cuentas.domain.usecase;

import com.api.cuentas.domain.model.usuario.*;
import com.api.cuentas.domain.model.usuario.gateway.PersonaGateway;
import com.api.cuentas.domain.usecase.exception.CodigoNoEncontradoException;
import com.api.cuentas.domain.usecase.exception.LogicaException;
import com.api.cuentas.domain.usecase.utils.UsuarioConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PersonaUseCase {

    private final PersonaGateway personaGateway;
    private final ClienteUseCase clienteUseCase;
    private final GeneroUseCase generoUseCase;
    private final TipoIdentificacionUseCase tipoIdentificacionUseCase;

    public List<Usuario> obtenerUsuarios() throws LogicaException {
        List<Usuario> response;
        try {
            response = UsuarioConverter.toUsuario(clienteUseCase.obtenerClientes());
        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    public Usuario obtenerUsuario(Integer id) throws LogicaException {
        Usuario response;
        try {
            Cliente cliente = Optional.ofNullable(clienteUseCase.obtenerCliente(id))
                    .orElseThrow(() -> new CodigoNoEncontradoException(id.toString()));
            response = UsuarioConverter.toUsuario(cliente);
        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    @Transactional
    public Usuario crearUsuario(Usuario usuario) throws LogicaException {
        Usuario response ;
        try {

            Persona persona = buildPersona(usuario);
            persona = personaGateway.save(persona);

            Cliente cliente = buildCliente(usuario, persona);
            cliente = clienteUseCase.crearCliente(cliente);

            response = UsuarioConverter.toUsuario(persona, cliente);

        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    @Transactional
    public Usuario actualizarUsuario(Usuario usuario) throws LogicaException {
        Usuario response;
        try {

            Cliente clienteOriginal = Optional.ofNullable(clienteUseCase.obtenerCliente(usuario.getIdCliente()))
                    .orElseThrow(() -> new CodigoNoEncontradoException(usuario.getIdCliente().toString()));

            Cliente clienteActualizado = UsuarioConverter.mapper(clienteOriginal, usuario);

            clienteActualizado.getPersona().setGenero(
                    obtenerGenero(usuario.getCodigoGenero())
            );
            clienteActualizado.getPersona().setTipoIdentificacion(
                    obtenerTipoIdentificacion(usuario.getCodigoTipoIdentificacion())
            );

            personaGateway.save(clienteActualizado.getPersona());
            clienteActualizado = clienteUseCase.crearCliente(clienteActualizado);

            response = UsuarioConverter.toUsuario(clienteActualizado);
        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    @Transactional
    public Boolean eliminarUsuario(Integer id) throws LogicaException {
        Boolean response = true;
        try {

            Cliente clienteOriginal = Optional.ofNullable(clienteUseCase.obtenerCliente(id))
                    .orElseThrow(() -> new CodigoNoEncontradoException(id.toString()));

            clienteUseCase.eliminarCliente(clienteOriginal.getId());
        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    private Genero obtenerGenero(String codigo) throws LogicaException {
        return Optional.ofNullable(generoUseCase.obtenerGenero(codigo))
                .orElseThrow(() -> new CodigoNoEncontradoException(codigo));
    }

    private TipoIdentificacion obtenerTipoIdentificacion(String codigo) throws CodigoNoEncontradoException {
        return Optional.ofNullable(tipoIdentificacionUseCase.obtenerTipoIdentificacion(codigo))
                .orElseThrow(() -> new CodigoNoEncontradoException(codigo));
    }

    private Persona buildPersona(Usuario usuario) throws LogicaException {
        return Persona.builder()
                .nombre(usuario.getNombres())
                .tipoIdentificacion(obtenerTipoIdentificacion(usuario.getCodigoTipoIdentificacion()))
                .genero(obtenerGenero(usuario.getCodigoGenero()))
                .edad(usuario.getEdad())
                .direccion(usuario.getDireccion())
                .telefono(usuario.getTelefono())
                .build();
    }

    private Cliente buildCliente(Usuario usuario, Persona persona) {
        return Cliente.builder()
                .contrasena(usuario.getContrasena())
                .estado(Boolean.TRUE)
                .persona(persona)
                .build();
    }

}
