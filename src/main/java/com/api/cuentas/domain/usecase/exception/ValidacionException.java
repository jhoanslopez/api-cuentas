package com.api.cuentas.domain.usecase.exception;

public class ValidacionException extends LogicaException {

    public ValidacionException(String message) {
        super(message);
    }

    public ValidacionException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
