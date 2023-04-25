package com.javarush.entity.islandModel;

import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.entity.organisms.animals.Animal;
import com.javarush.service.OrganismTask;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
public class Location {
    int numProcessors = Runtime.getRuntime().availableProcessors();
    ExecutorService threadPool = Executors.newFixedThreadPool(numProcessors);
    private final int xPosition;
    private final int yPosition;
    private volatile double plant;
    private final List<Location> nearbyLocations = new ArrayList<>(); //!
    private final Map<Class<? extends BasalOrganism>, Set<BasalOrganism>> animals = new ConcurrentHashMap<>(); //!
    private final Lock lock = new ReentrantLock(true); //!

    public Location(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    public void init() {
        for (Class<? extends BasalOrganism> animalClass : animals.keySet()) {
            for (BasalOrganism animal : animals.get(animalClass)) {
                threadPool.submit(new OrganismTask(animal, this));
            }
        }

    }

    public void addLifeToLocation(BasalOrganism basalOrganism) {
//        return animals.get(animalClass).size() < Setting.BASIC_PARAMETERS_OF_ANIMALS.get(animalClass)[1];


    }


}
