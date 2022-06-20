package ru.javarush.drogunov.wildisland.enity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.javarush.drogunov.wildisland.annotations.UnitSetting;

import java.util.concurrent.atomic.AtomicLong;

@Data
@EqualsAndHashCode
public abstract class GameUnit {

    //clone
 //tostring
    private static final AtomicLong idcur = new AtomicLong(System.currentTimeMillis());
    private final long id = idcur.incrementAndGet();

    private String icon;
    private double weight;



    @Override
    public String toString() {
        UnitSetting annotation = getClass().getAnnotation(UnitSetting.class);
        //TODO Вопрос тут вместо конкатенации лучше было бы использовать StringBuilder??
        return annotation.name() + " " + annotation.icon();
    }
}
