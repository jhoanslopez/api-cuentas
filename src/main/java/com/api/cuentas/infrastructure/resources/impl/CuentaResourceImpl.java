package com.api.cuentas.infrastructure.resources.impl;

import com.api.cuentas.domain.model.cuenta.Cuenta;
import com.api.cuentas.domain.model.cuenta.CuentaActualizar;
import com.api.cuentas.domain.model.cuenta.CuentaCliente;
import com.api.cuentas.domain.model.usuario.Usuario;
import com.api.cuentas.domain.usecase.CuentaUseCase;
import com.api.cuentas.domain.usecase.exception.LogicaException;
import com.api.cuentas.infrastructure.resources.CuentaResource;
import com.api.cuentas.infrastructure.resources.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CuentaResourceImpl implements CuentaResource {

    private final CuentaUseCase cuentaUseCase;
    @Override
    public ResponseEntity<List<CuentaCliente>> obtenerCuentas() {
        ResponseEntity httpResponse;
        try{
            List<CuentaCliente> response = cuentaUseCase.obtenerCuentas();
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = ResponseUtil.badRequest(e);
        }catch (Exception e){
            httpResponse = ResponseUtil.internalServerError(e);
        }
        return httpResponse;
    }

    @Override
    public ResponseEntity<CuentaCliente> obtenerCuenta(Integer id) {
        ResponseEntity httpResponse;
        try{
            CuentaCliente response = cuentaUseCase.obtenerCuenta(id);
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = ResponseUtil.badRequest(e);
        }catch (Exception e){
            httpResponse = ResponseUtil.internalServerError(e);
        }
        return httpResponse;
    }

    @Override
    public ResponseEntity<CuentaCliente> crearCuenta(Cuenta cuenta) {
        ResponseEntity httpResponse;
        try{
            CuentaCliente response = cuentaUseCase.crearCuenta(cuenta);
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = ResponseUtil.badRequest(e);
        }catch (Exception e){
            httpResponse = ResponseUtil.internalServerError(e);
        }
        return httpResponse;
    }

    @Override
    public ResponseEntity<CuentaCliente> actualizarCuenta(CuentaActualizar cuentaActualizar) {
        ResponseEntity httpResponse;
        try{
            CuentaCliente response = cuentaUseCase.actualizarCuenta(cuentaActualizar);
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = ResponseUtil.badRequest(e);
        }catch (Exception e){
            httpResponse = ResponseUtil.internalServerError(e);
        }
        return httpResponse;
    }

    @Override
    public ResponseEntity<Boolean> eliminarCuenta(Integer id) {
        ResponseEntity httpResponse;
        try{
            Boolean response = cuentaUseCase.eliminarCuenta(id);
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = ResponseUtil.badRequest(e);
        }catch (Exception e){
            httpResponse = ResponseUtil.internalServerError(e);
        }
        return httpResponse;
    }

}
