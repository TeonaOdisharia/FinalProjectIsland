package com.javarush.entity.organisms.animals.predators;

import com.javarush.entity.organisms.animals.herbivores.Herbivore;
import com.javarush.helper.YamlOrganism;

import java.util.Map;

public class Eagle extends Predator {
    public Eagle(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed, int energy, double foodForLife, Map<String, Integer> eatingMap) {
        super(monitor, name, icon, weight, maxCountOnCell, speed, energy, foodForLife, eatingMap);
    }

    public Eagle(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}