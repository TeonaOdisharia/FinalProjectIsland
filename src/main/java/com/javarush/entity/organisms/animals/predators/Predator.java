package com.javarush.entity.organisms.animals.predators;

import com.javarush.entity.organisms.animals.Animal;
import com.javarush.helper.YamlOrganism;

import java.util.Map;

public abstract class Predator extends Animal {
    public Predator(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed, int energy, double foodForLife, Map<String, Integer> eatingMap) {
        super(monitor, name, icon, weight, maxCountOnCell, speed, energy, foodForLife, eatingMap);
    }

    public Predator(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
