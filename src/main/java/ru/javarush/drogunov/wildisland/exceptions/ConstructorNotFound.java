package ru.javarush.drogunov.wildisland.exceptions;

public class ConstructorNotFound extends RuntimeException {
    public ConstructorNotFound(String constructor_not_found, NoSuchMethodException e) {
    }
}
