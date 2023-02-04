package com.api.cuentas.domain.usecase.exception;

public class LogicaException extends Exception {

    public LogicaException(String message) {
        super(message);
    }

    public LogicaException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
