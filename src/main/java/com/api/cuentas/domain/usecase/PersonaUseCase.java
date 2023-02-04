package com.api.cuentas.domain.usecase;

import com.api.cuentas.domain.model.usuario.*;
import com.api.cuentas.domain.model.usuario.gateway.PersonaGateway;
import com.api.cuentas.domain.usecase.exception.CodigoNoEncontradoException;
import com.api.cuentas.domain.usecase.exception.LogicaException;
import com.api.cuentas.domain.usecase.exception.ValidacionException;
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

    public List<Persona> obtenerUsuarios() {
        return personaGateway.findAll();
    }

    public Persona obtenerUsuario(Integer id) {
        return personaGateway.findById(id);
    }

    @Transactional
    public Usuario crearUsuario(Usuario usuario) throws LogicaException {
        Usuario response = null;
        try {

            Persona persona = buildPersona(usuario);
            persona = personaGateway.save(persona);

            Cliente cliente = buildCliente(usuario, persona);
            cliente.setPersona(null);
            cliente = clienteUseCase.crearCliente(cliente);

            usuario = UsuarioConverter.toUsuario(persona, cliente);

        } catch (Exception e) {
            throw new LogicaException(e.getMessage(), e);
        }
        return response;
    }

    @Transactional
    public Usuario actualizarUsuario(Usuario usuario) {
        return null;
    }

    @Transactional
    public Persona eliminarUsuario(Integer id) {
        return null;
    }

    private Genero obtenerGenero(String codigo) throws LogicaException {
        return Optional.ofNullable(generoUseCase.obtenerGenero(codigo))
                .orElseThrow(() -> new CodigoNoEncontradoException(codigo));
    }

    private TipoIdentificacion obtenerTipoIdentificacion(String codigo) {
        return tipoIdentificacionUseCase.obtenerTipoIdentificacion(codigo);
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
