package ru.javarush.drogunov.wildisland.exceptions;

public class ClassForDependenceNotFound extends RuntimeException {
    public ClassForDependenceNotFound(String message) {
        super(message);
    }

    public ClassForDependenceNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
