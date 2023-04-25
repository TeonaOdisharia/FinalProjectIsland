package com.javarush.entity.organisms.animals;

import com.javarush.entity.organisms.BasalOrganism;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class Animal extends BasalOrganism {
    private int energy;
    private double foodForLife;
    private Map<String, Integer> eatingMap;

    public Animal(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed, int energy, double foodForLife, Map<String, Integer> eatingMap) {
        super(monitor, name, icon, weight, maxCountOnCell, speed);
        this.energy = energy;
        this.foodForLife = foodForLife;
        this.eatingMap = eatingMap;
    }
}
