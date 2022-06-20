/*
package ru.javarush.drogunov.wildisland.servises;

import lombok.RequiredArgsConstructor;
import ru.javarush.drogunov.wildisland.Constants;
import ru.javarush.drogunov.wildisland.enity.GameUnit;
import ru.javarush.drogunov.wildisland.game_space.GameSpace;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static ru.javarush.drogunov.wildisland.Constants.GAME_UNITS;

@RequiredArgsConstructor
public class GameWorker extends Thread {
    public static final int PERIOD = 1000;
    private final GameSpace game;

    @Override
    public void run() {
        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(4);

        List<GameUnit> workers = GAME_UNITS.keySet()
                .stream()
                .map(p -> new GameUnit(p, game()))
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
        }, PERIOD, PERIOD, TimeUnit.MILLISECONDS); //TODO need config
    }
}
*/
