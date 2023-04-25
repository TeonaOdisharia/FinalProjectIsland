package com.javarush.service;

import com.javarush.entity.islandModel.Location;
import com.javarush.generators.IslandGenerator;
import com.javarush.settings.Settings;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class IslandTask {
    private final IslandGenerator island;
    private final int stepDuration = Settings.DURATION;
    private final int numberOfSimulationSteps = Settings.NUMBER_OF_SIMULATION;
    private final AtomicInteger simulationStepNumber = new AtomicInteger(0);
    private final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    private final Runnable islandLifeTask = new Runnable() {

        @Override
        public void run() {
            Location[][] locations = island.getIslandMap().getLocations();
            startingTheSimulation(locations);

            if (simulationStepNumber.get() >= numberOfSimulationSteps) {
                service.shutdown();
                for (int i = 0; i < locations.length * locations[0].length; i++) {
                    locations[i / locations[0].length][i % locations[0].length].shutdown();
                }
                for (int i = 0; i < locations.length * locations[0].length; i++) {
                    try {
                        locations[i / locations[0].length][i % locations[0].length].awaitTermination(stepDuration);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                island.getIslandMap().showIsland();
            }
        }
    };

    public void start() {
        service.scheduleAtFixedRate(islandLifeTask, 1, stepDuration, TimeUnit.MILLISECONDS);
    }

    private void startingTheSimulation( Location[][] locations) {
        simulationStepNumber.incrementAndGet();
        island.getIslandMap().showIsland();
        for (int i = 0; i < locations.length * locations[0].length; i++) {
            locations[i / locations[0].length][i % locations[0].length].start();
        }
    }

    public IslandTask(IslandGenerator island) {
        this.island = island;
    }
}