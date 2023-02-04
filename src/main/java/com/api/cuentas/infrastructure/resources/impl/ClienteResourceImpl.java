package com.api.cuentas.infrastructure.resources.impl;

import com.api.cuentas.domain.model.usuario.Usuario;
import com.api.cuentas.domain.usecase.PersonaUseCase;
import com.api.cuentas.domain.usecase.exception.LogicaException;
import com.api.cuentas.infrastructure.resources.ClienteResource;
import com.api.cuentas.infrastructure.resources.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClienteResourceImpl implements ClienteResource {

    private final PersonaUseCase personaUseCase;

    @Override
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        ResponseEntity httpResponse;
        try{
            List<Usuario> response = personaUseCase.obtenerUsuarios();
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = ResponseUtil.badRequest(e);
        }catch (Exception e){
            httpResponse = ResponseUtil.internalServerError(e);
        }
        return httpResponse;
    }

    @Override
    public ResponseEntity<Usuario> obtenerUsuario(Integer id) {
        ResponseEntity httpResponse;
        try{
            Usuario response = personaUseCase.obtenerUsuario(id);
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = ResponseUtil.badRequest(e);
        }catch (Exception e){
            httpResponse = ResponseUtil.internalServerError(e);
        }
        return httpResponse;
    }

    @Override
    public ResponseEntity<Usuario> crearUsuario(Usuario usuario) {
        ResponseEntity httpResponse;
        try{
            Usuario response = personaUseCase.crearUsuario(usuario);
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = ResponseUtil.badRequest(e);
        }catch (Exception e){
            httpResponse = ResponseUtil.internalServerError(e);
        }
        return httpResponse;
    }

    @Override
    public ResponseEntity<Usuario> actualizarUsuario(Usuario usuario) {
        ResponseEntity httpResponse;
        try{
            Usuario response = personaUseCase.actualizarUsuario(usuario);
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = ResponseUtil.badRequest(e);
        }catch (Exception e){
            httpResponse = ResponseUtil.internalServerError(e);
        }
        return httpResponse;
    }

    @Override
    public ResponseEntity<Boolean> eliminarUsuario(Integer id) {
        ResponseEntity httpResponse;
        try{
            Boolean response = personaUseCase.eliminarUsuario(id);
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = ResponseUtil.badRequest(e);
        }catch (Exception e){
            httpResponse = ResponseUtil.internalServerError(e);
        }
        return httpResponse;
    }
}
