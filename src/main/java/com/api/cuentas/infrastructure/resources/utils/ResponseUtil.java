package com.api.cuentas.infrastructure.resources.utils;

import com.api.cuentas.infrastructure.resources.MensajeError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseUtil {

    public static ResponseEntity<MensajeError> badRequest(Exception e) {
        return getResponse(e, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<MensajeError> internalServerError(Exception e) {
        return getResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static ResponseEntity<MensajeError> getResponse(Exception e, HttpStatus status) {
        return new ResponseEntity<>(
                MensajeError.builder()
                        .mensaje(e.getMessage())
                        .build(),
                status);
    }

}
