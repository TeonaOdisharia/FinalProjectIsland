package com.javarush.service;

import com.javarush.entity.islandModel.Location;
import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.entity.organisms.animals.Animal;
import com.javarush.entity.organisms.animals.predators.Predator;
import com.javarush.helper.Randomizer;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public interface OrganismsBehaviors {
    default void eat(Location location) {
        location.getLock().lock();
        Predator predator = (Predator) this;
        try {
            if (predator.getSatiation() < predator.getEnergy()) {
                Map<String, Integer> mealList = predator.getMealList();
                Optional<BasalOrganism> firstVictim = location.getAnimals().stream()
                        .filter(animal -> mealList.containsKey(animal.getName()))
                        .findFirst();
                if (firstVictim.isPresent()) {
                    BasalOrganism victim = firstVictim.get();
                    Integer energyPercentage = mealList.get(victim.getName());
                    if (energyPercentage > 0) predator.setEnergy(predator.getEnergy() * 100 / energyPercentage);
                    location.removeAnimal(victim);
                } else {
//                    System.out.println("No victim found");
                }
            }

        } finally {
            location.getLock().unlock();
        }

    }

    default void move(Location location) {
        location.getLock().lock();
        Location destinationLocation = getDestinationLocation(location);
        BasalOrganism organism = (BasalOrganism) this;
        try {
            if (destinationLocation.isEnoughSpace(organism)) {
                destinationLocation.addAnimal(organism);
                location.removeAnimal(organism);
            }
        } finally {
            location.getLock().unlock();
        }
    }

    private Location getDestinationLocation(Location location) {
        BasalOrganism organism = (BasalOrganism) this;
        int steps = organism.getSpeed();
        for (int i = steps; i >= 0; i--) {
            List<Location> nearbyLocations = location.getNearbyLocations();
            location = nearbyLocations.get(Randomizer.getNumber(0, nearbyLocations.size()));
        }
        return location;
    }

    default void reproduction(Location location) {
        location.getLock().lock();
        BasalOrganism organism = (BasalOrganism) this;
        try {
            BasalOrganism animalPair = location.getPair(organism);
            if (animalPair == null && location.isEnoughSpace(organism)) {
                BasalOrganism clone = organism.clone();
                location.addAnimal(clone);
            }
        } finally {
            location.getLock().unlock();
        }
    }

    default void die(Location location) {
        location.getLock().lock();
        BasalOrganism organism = (BasalOrganism) this;
        try {
            if (organism.getWeight() == 0) {
                location.removeAnimal(organism);
            }
        } finally {
            location.getLock().unlock();
        }

    }


}
