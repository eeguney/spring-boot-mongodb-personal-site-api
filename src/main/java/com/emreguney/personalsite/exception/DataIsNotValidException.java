package com.emreguney.personalsite.exception;

public class DataIsNotValidException extends RuntimeException {
    public DataIsNotValidException(String message) {
        super(message);
    }
    public DataIsNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
