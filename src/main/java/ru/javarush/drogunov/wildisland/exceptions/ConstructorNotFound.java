package ru.javarush.drogunov.wildisland.exceptions;

public class ConstructorNotFound extends RuntimeException {
    public ConstructorNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
