package org.example;

public class NotFoundRegisteredException extends RuntimeException {
    public NotFoundRegisteredException(String s) {
        super((s));
    }
}
