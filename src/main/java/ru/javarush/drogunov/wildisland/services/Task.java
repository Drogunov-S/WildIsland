package ru.javarush.drogunov.wildisland.services;

import ru.javarush.drogunov.wildisland.enity.game_unit.GameUnit;

import java.util.function.Consumer;

public class Task {

    private final GameUnit gameUnit;
    private final Consumer<GameUnit> operation;

    public Task(GameUnit gameUnit, Consumer<GameUnit> operation) {
        this.gameUnit = gameUnit;
        this.operation = operation;

    }

    public void run() {
        operation.accept(gameUnit);
    }
}
