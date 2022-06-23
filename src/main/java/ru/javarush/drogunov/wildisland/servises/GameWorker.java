package ru.javarush.drogunov.wildisland.servises;


import ru.javarush.drogunov.wildisland.enity.Game;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWorker extends Thread {
    public static final int PERIOD = 1000;
    private final Game game;

    public GameWorker(Game game) {
        this.game = game;
    }

    @Override
    public void run() {

        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(4);

        List<GameUnitWorker> workers = game.getGameMap().getSetUnits()
                .stream()
                .map(p -> new GameUnitWorker(p, game.getGameMap()))
                .toList();

        mainPool.scheduleAtFixedRate(() -> {
            ExecutorService servicePool = Executors.newFixedThreadPool(15);
            workers.forEach(servicePool::submit);
            servicePool.shutdown();
            try {
                if (servicePool.awaitTermination(PERIOD, TimeUnit.MILLISECONDS)) {
//                    game.getView().showMap();
                    game.getView().showStatistics();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, PERIOD, PERIOD, TimeUnit.MILLISECONDS);



        /*ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(2);
List<Ga>


        Collection<Set<GameUnit>> values = game.getGameMap().getMapGameUnits().values();
        for (Set<GameUnit> value : values) {
            value.stream().map(gameUnit -> new GameUnitWorker(gameUnit, game.getGameMap());
        }


        List<GameUnit> workers = game.getGameMap().getMapGameUnits().values()
                .stream()
                .map(p -> p.stream().map( gameUnit ->
                                new GameUnitWorker(p, game.getGameMap()))
                        .toList();
        mainPool.scheduleAtFixedRate(() -> {
            ExecutorService servicePool = Executors.newFixedThreadPool(4);
            workers.forEach(servicePool::submit);
            servicePool.shutdown();
            try {
                if (servicePool.awaitTermination(PERIOD, TimeUnit.MILLISECONDS)) {
                    game.getView().showMap();
                    game.getView().showStatistics();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, PERIOD, PERIOD, TimeUnit.MILLISECONDS); //TODO need config*/
    }
}
