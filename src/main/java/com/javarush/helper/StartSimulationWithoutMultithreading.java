package com.javarush.helper;

import com.javarush.entity.islandModel.IslandMap;
import com.javarush.entity.islandModel.Location;
import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.entity.organisms.plants.Pitcher;
import com.javarush.entity.organisms.plants.Plant;
import com.javarush.settings.Settings;

import java.util.ArrayList;
import java.util.List;

public class StartSimulationWithoutMultithreading {

//    public static void startSimulation(IslandMap island){
//        Location[][] locations = island.getLocations();
//        for (int i = 0; i < Settings.X_POSITION; i++) {
//            for (int j = 0; j < Settings.Y_POSITION; j++) {
//                Location location = locations[i][j];
//                List<BasalOrganism> animals = location.getAnimals();
//                try {
//                    for (BasalOrganism organism : animals) {
//                        if (organism instanceof Pitcher) {
//                            organism.eat(location);
//                            organism.reproduction(location);
//                            organism.die(location);
//                        } else if (organism instanceof Plant) {
//                            organism.reproduction(location);
//                            organism.die(location);
//                        } else {
//                            organism.eat(location);
//                            organism.move(location);
//                            organism.reproduction(location);
//                            organism.die(location);
//                        }
//                    }
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }

    public static void startSimulation(IslandMap island) {
        Location[][] locations = island.getLocations();
        for (int i = 0; i < Settings.X_POSITION; i++) {
            for (int j = 0; j < Settings.Y_POSITION; j++) {
                Location location = locations[i][j];
                List<BasalOrganism> animals = location.getAnimals();
                List<BasalOrganism> newAnimals = new ArrayList<>(); // Store new organisms
                List<BasalOrganism> deadAnimals = new ArrayList<>(); // Store dead organisms
                try {
                    for (BasalOrganism organism : animals) {
                        if (organism instanceof Pitcher) {
                            deadAnimals.add(organism.eatSafe(location));
                            newAnimals.add(organism.reproductionSafe(location));
                            if (organism.dieSafe(location)) {
                                deadAnimals.add(organism);
                            }
                        } else if (organism instanceof Plant) {
                            newAnimals.add(organism.reproductionSafe(location));
                            if (organism.dieSafe(location)) {
                                deadAnimals.add(organism);
                            }
                        } else {
                            BasalOrganism victim = organism.eatSafe(location);
                            if (victim != null) {
                                deadAnimals.add(victim);
                            }
                            organism.moveSafe(location);
                            newAnimals.add(organism.reproductionSafe(location));
                            if (organism.dieSafe(location)) {
                                deadAnimals.add(organism);
                            }
                        }
                    }
                    animals.removeAll(deadAnimals);
                    animals.addAll(newAnimals);
                    location.setAnimals(animals);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
