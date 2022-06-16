package ru.javarush.drogunov.wildisland.enity.animals;

import lombok.Data;
import ru.javarush.drogunov.wildisland.game_space.Cell;
import ru.javarush.drogunov.wildisland.interfaces.Actionable;
import ru.javarush.drogunov.wildisland.interfaces.Multiple;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@Data
public abstract class GameUnit implements Actionable, Multiple {
    private static final AtomicLong idcur = new AtomicLong(System.currentTimeMillis());

//    private final AtomicInteger id = new AtomicInteger(0);
    private final long id = idcur.incrementAndGet();

    private String viewAnimal;
    private int weight;
    private int satiety;
    private int maxSteps;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameUnit)) return false;
        GameUnit gameUnit = (GameUnit) o;
        return id == gameUnit.id && weight == gameUnit.weight && satiety == gameUnit.satiety && maxSteps == gameUnit.maxSteps && Objects.equals(viewAnimal, gameUnit.viewAnimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, viewAnimal, weight, satiety, maxSteps);
    }

    public GameUnit() {
//        id.getAndIncrement();
//        System.out.println("Конструктор" + toString());
    }

    @Override
    public void eat(GameUnit one, GameUnit two) {

    }

    @Override
    public void multiply(GameUnit one, GameUnit two) {

    }

    @Override
    public void walk(Cell current, Cell target) {

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    //TODO иквелс и хэшкод
}
