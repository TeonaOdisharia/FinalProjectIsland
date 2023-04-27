package com.javarush.entity.islandModel;

import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.entity.organisms.animals.Animal;
import com.javarush.service.OrganismTask;
import com.javarush.service.OrganismsBehaviors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Getter
@Setter
public class Location {
    int numProcessors = Runtime.getRuntime().availableProcessors();
    ExecutorService threadPool = Executors.newFixedThreadPool(numProcessors);
    private volatile int xPosition;
    private volatile int yPosition;
    private volatile double plant;
    private volatile List<Location> nearbyLocations = new ArrayList<>(); //!
    private volatile List<BasalOrganism> animals = new ArrayList<>(); //!
    private final Lock lock = new ReentrantLock(true); //!

    public Location(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    public void start() {
        lock.lock();
        try {
            for (BasalOrganism organism : animals) {
                threadPool.submit(new OrganismTask(organism, this));
            }
        } finally {
            lock.unlock();
        }
    }

    public void awaitTermination(int milliseconds) throws InterruptedException {
        threadPool.awaitTermination(milliseconds, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
        threadPool.shutdown();
    }


    public boolean isEnoughSpace(BasalOrganism organism) {
        Map<BasalOrganism, Long> objectCounts = animals.stream()
                .collect(Collectors.groupingBy(animal -> animal, Collectors.counting()));

        long amountOfAnimal = objectCounts.entrySet().stream()
                .filter(entry -> organism.getClass().equals(entry.getKey().getClass()))
                .mapToLong(Map.Entry::getValue)
                .sum();

        return organism.getMaxCountOnCell() > amountOfAnimal;
    }

    public void addAnimal(BasalOrganism organism) {
        if (isEnoughSpace(organism)) animals.add(organism);
    }

    public void removeAnimal(BasalOrganism organism) {
        animals.remove(organism);
    }

    public BasalOrganism getAnimal(BasalOrganism organism) {
        Optional<BasalOrganism> foundOrganism = animals.stream()
                .filter(animal -> animal.equals(organism))
                .findFirst();

        return foundOrganism.orElse(null);
    }

    public BasalOrganism getPair(BasalOrganism organism) {
        Optional<BasalOrganism> foundOrganism = animals.stream()
                .filter(animal -> !animal.equals(organism) && animal.getClass().equals(organism.getClass()))
                .findFirst();

        return foundOrganism.orElse(null);
    }
}
