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

    @Override
    public String toString() {



        return "Location{}";


    }
}
