package com.javarush.entity.organisms.animals.herbivores;

import com.javarush.helper.YamlOrganism;

import java.util.Map;

public class Frog extends Herbivore{
    public Frog(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed, int energy, double foodForLife, Map<String, Integer> eatingMap) {
        super(monitor, name, icon, weight, maxCountOnCell, speed, energy, foodForLife, eatingMap);
    }

    public Frog(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
