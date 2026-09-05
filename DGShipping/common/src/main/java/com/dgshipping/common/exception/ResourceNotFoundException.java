package com.dgshipping.common.exception;

/**
 * Thrown by any module when a requested resource does not exist.
 * Handled centrally by {@link GlobalExceptionHandler}.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
