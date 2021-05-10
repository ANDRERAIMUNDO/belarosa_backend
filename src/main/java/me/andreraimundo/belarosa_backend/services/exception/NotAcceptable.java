package me.andreraimundo.belarosa_backend.services.exception;

public class NotAcceptable extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public NotAcceptable(String msg) {
		super(msg);
	}

	public NotAcceptable(String msg, Throwable cause) {
		super(msg, cause);
	}
}