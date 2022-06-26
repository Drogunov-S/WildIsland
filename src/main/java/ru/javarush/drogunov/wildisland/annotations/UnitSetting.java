package ru.javarush.drogunov.wildisland.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UnitSetting {
    int minPopulations() default 0;
    int maxPopulations();
    String icon();
    String name();
    double weight();
    double satiety() default 0;
    int maxSteps() default 0;

}
