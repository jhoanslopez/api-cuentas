package com.api.cuentas.infrastructure.resources.impl;

import com.api.cuentas.domain.model.usuario.Persona;
import com.api.cuentas.domain.model.usuario.Usuario;
import com.api.cuentas.domain.usecase.PersonaUseCase;
import com.api.cuentas.domain.usecase.exception.LogicaException;
import com.api.cuentas.infrastructure.resources.MensajeError;
import com.api.cuentas.infrastructure.resources.UsuarioResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsuarioResourceImpl implements UsuarioResource {

    private final PersonaUseCase personaUseCase;

    @Override
    public List<Persona> obtenerUsuarios() {
        return personaUseCase.obtenerUsuarios();
    }

    @Override
    public Persona obtenerUsuario(Integer id) {
        return personaUseCase.obtenerUsuario(id);
    }

    @Override
    public ResponseEntity<Usuario> crearUsuario(Usuario usuario) throws LogicaException {
        ResponseEntity<Usuario> httpResponse;
        try{
            Usuario response = personaUseCase.crearUsuario(usuario);
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = new ResponseEntity(
                    MensajeError.builder()
                            .mensaje(e.getMessage())
                            .build(),
                    HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            httpResponse = new ResponseEntity(
                    MensajeError.builder()
                            .mensaje(e.getMessage())
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return httpResponse;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return personaUseCase.actualizarUsuario(usuario);
    }

    @Override
    public Persona eliminarUsuario(Integer id) {
        return personaUseCase.eliminarUsuario(id);
    }
}
