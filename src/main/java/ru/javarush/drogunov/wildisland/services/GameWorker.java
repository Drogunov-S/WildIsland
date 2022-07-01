package ru.javarush.drogunov.wildisland.services;


import ru.javarush.drogunov.wildisland.enity.Game;
import ru.javarush.drogunov.wildisland.view.View;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static ru.javarush.drogunov.wildisland.Constants.GAME_UNITS;

public class GameWorker extends Thread {
    public static final int PERIOD = 500;

    private final Game game;

    public GameWorker(Game game) {
        this.game = game;
    }

    @Override
    public void run() {

        View view = game.getView();
        view.showStatistics();
//        view.showCountCellUnits();


        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(2);

        List<GameUnitWorker> workers = GAME_UNITS.keySet()
                .stream()
                .map(p -> new GameUnitWorker(p, game.getGameMap()))
                .toList();
        mainPool.scheduleWithFixedDelay(() -> {
            ExecutorService servicePool = Executors.newFixedThreadPool(16);
            Thread.currentThread().setName("GameWorker MainPool");
            workers.forEach(servicePool::submit);
            servicePool.shutdown();


            try {
                if (servicePool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS)) {
                    game.getGameMap().accessOnAll();
//                        game.getView().showMap();
                    game.getView().showStatistics();
//                        game.getView().showCountCellUnits();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (game.getGameMap().isFinished()) {
                view.showFinishMassage();
                mainPool.shutdownNow();
            }


        }, PERIOD, PERIOD, TimeUnit.MILLISECONDS);

}
}
