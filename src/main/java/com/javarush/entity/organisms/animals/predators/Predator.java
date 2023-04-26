package com.javarush.entity.organisms.animals.predators;

import com.javarush.entity.organisms.animals.Animal;
import com.javarush.helper.YamlOrganism;

import java.util.Map;

public abstract class Predator extends Animal {
    public Predator(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed) {
        super(monitor, name, icon, weight, maxCountOnCell, speed);
    }

    public Predator(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
