package me.andreraimundo.belarosa_backend.services.exception;

public class MercadoPagoException extends RuntimeException {
    public MercadoPagoException(String message) {
        super(message);
    }
}