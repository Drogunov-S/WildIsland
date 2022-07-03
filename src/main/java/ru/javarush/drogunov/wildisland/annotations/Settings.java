package ru.javarush.drogunov.wildisland.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface Settings {
    //Should have been used to crate config and selection settings
    @SuppressWarnings("unused") int code();

    @SuppressWarnings("unused") String name();

}
