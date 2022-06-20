package ru.javarush.drogunov.wildisland.exceptions;

public class ClassNotInstanceException extends RuntimeException {
    public ClassNotInstanceException(String message, Throwable cause) {
        super(message, cause);
    }
}
