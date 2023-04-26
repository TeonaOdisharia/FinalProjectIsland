package com.javarush.entity.organisms.animals.predators;

import com.javarush.entity.organisms.animals.herbivores.Herbivore;
import com.javarush.helper.YamlOrganism;

import java.util.Map;

public class Bear extends Predator {
    public Bear(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed, int energy, double foodForLife, Map<String, Integer> eatingMap) {
        super(monitor, name, icon, weight, maxCountOnCell, speed, energy, foodForLife, eatingMap);
    }

    public Bear(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
