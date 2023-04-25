package com.javarush.entity.organisms;

import com.javarush.entity.islandModel.Location;
import com.javarush.service.OrganismsBehaviors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BasalOrganism implements OrganismsBehaviors {
    Object monitor;
    private String name;
    private String icon;
    private double weight;
    private int maxCountOnCell;
    private int speed;

    protected Class<? extends BasalOrganism> aClass;
    private final Lock lock = new ReentrantLock(true);

    public BasalOrganism(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed) {
        this.monitor = monitor;
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.maxCountOnCell = maxCountOnCell;
        this.speed = speed;
    }

    public BasalOrganism(BasalOrganism animal, Location location) {

    }
}
