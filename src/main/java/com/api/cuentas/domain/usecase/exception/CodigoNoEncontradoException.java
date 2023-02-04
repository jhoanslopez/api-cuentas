package com.api.cuentas.domain.usecase.exception;

public class CodigoNoEncontradoException extends LogicaException {

    private static final String MESSAGE = "Código no encontrado: %s";

    public CodigoNoEncontradoException(String code) {
        super(String.format(MESSAGE, code));
    }

    public CodigoNoEncontradoException(String code, Throwable throwable) {
        super(String.format(MESSAGE, code), throwable);
    }
}
