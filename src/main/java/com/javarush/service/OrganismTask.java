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
                organism.eat();
                organism.reproduction();
                organism.die();
            } else if (organism instanceof Plant plant) {
                organism.reproduction();
                organism.die();
            } else {
                organism.eat();
                organism.move();
                organism.reproduction();
                organism.die();
            }
        } catch (Exception e) {
            throw new IslandException(e);
        } finally {
            organism.getLock().unlock();
        }
    }
}
