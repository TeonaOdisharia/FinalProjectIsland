package com.javarush.service;

import com.javarush.entity.islandModel.Location;
import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.entity.organisms.plants.Pitcher;
import com.javarush.entity.organisms.plants.Plant;
import com.javarush.exceptions.IslandException;

public class OrganismTask implements Runnable {
    private final BasalOrganism organism;
    private final Location location;

    public OrganismTask(BasalOrganism organism, Location location) {
        this.organism = organism;
        this.location = location;
    }

    @Override
    public void run() {
        organism.getLock().lock();

        try {
            if (organism instanceof Pitcher pitcher) {
                organism.eat(location);
                organism.reproduction(location);
                organism.die(location);
            } else if (organism instanceof Plant plant) {
                organism.reproduction(location);
                organism.die(location);
            } else {
                organism.eat(location);
                organism.move(location);
                organism.reproduction(location);
                organism.die(location);
            }
        } catch (Exception e) {
            throw new IslandException(e);
        } finally {
            organism.getLock().unlock();
        }
    }
}
