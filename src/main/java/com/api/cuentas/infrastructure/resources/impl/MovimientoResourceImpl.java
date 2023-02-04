package com.api.cuentas.infrastructure.resources.impl;

import com.api.cuentas.domain.model.movimiento.MovimientoCuenta;
import com.api.cuentas.domain.model.movimiento.MovimientoGenerar;
import com.api.cuentas.domain.usecase.MovimientoUseCase;
import com.api.cuentas.domain.usecase.exception.LogicaException;
import com.api.cuentas.infrastructure.resources.MovimientoResource;
import com.api.cuentas.infrastructure.resources.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovimientoResourceImpl implements MovimientoResource {

    private final MovimientoUseCase movimientoUseCase;


    @Override
    public ResponseEntity<List<MovimientoCuenta>> obtenerMovimientos() {
        ResponseEntity httpResponse;
        try{
            List<MovimientoCuenta> response = movimientoUseCase.obtenerMovimientos();
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = ResponseUtil.badRequest(e);
        }catch (Exception e){
            httpResponse = ResponseUtil.internalServerError(e);
        }
        return httpResponse;
    }

    @Override
    public ResponseEntity<MovimientoCuenta> obtenerMovimiento(Integer id) {
        ResponseEntity httpResponse;
        try{
            MovimientoCuenta response = movimientoUseCase.obtenerMovimiento(id);
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = ResponseUtil.badRequest(e);
        }catch (Exception e){
            httpResponse = ResponseUtil.internalServerError(e);
        }
        return httpResponse;
    }

    @Override
    public ResponseEntity<MovimientoCuenta> generarMovimiento(MovimientoGenerar movimientoGenerar) {
        ResponseEntity httpResponse;
        try{
            MovimientoCuenta response = movimientoUseCase.generarMovimiento(movimientoGenerar);
            httpResponse = ResponseEntity.ok(response);
        }catch(LogicaException e) {
            httpResponse = ResponseUtil.badRequest(e);
        }catch (Exception e){
            httpResponse = ResponseUtil.internalServerError(e);
        }
        return httpResponse;
    }
}
