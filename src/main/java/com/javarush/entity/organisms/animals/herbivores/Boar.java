package com.javarush.entity.organisms.animals.herbivores;

import com.javarush.entity.organisms.animals.predators.Predator;
import com.javarush.helper.YamlOrganism;

import java.util.Map;

public class Boar extends Herbivore {
    public Boar(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }

    public Boar(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed, int energy, double foodForLife, Map<String, Integer> eatingMap) {
        super(monitor, name, icon, weight, maxCountOnCell, speed, energy, foodForLife, eatingMap);
    }
}
