package com.javarush.entity.organisms.animals.omnivores;

import com.javarush.entity.organisms.animals.Animal;
import com.javarush.helper.YamlOrganism;

import java.util.Map;

public abstract class Omnivore extends Animal {
    public Omnivore(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed, int energy, double foodForLife, Map<String, Integer> eatingMap) {
        super(monitor, name, icon, weight, maxCountOnCell, speed, energy, foodForLife, eatingMap);
    }

    public Omnivore(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
