package com.javarush.entity.organisms.animals.herbivores;

import com.javarush.entity.organisms.animals.predators.Predator;
import com.javarush.helper.YamlOrganism;

import java.util.Map;

public class Buffalo extends Herbivore {
    public Buffalo(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed, int energy, double foodForLife, Map<String, Integer> eatingMap) {
        super(monitor, name, icon, weight, maxCountOnCell, speed, energy, foodForLife, eatingMap);
    }

    public Buffalo(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}