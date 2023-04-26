package com.javarush.entity.organisms.animals.predators;

import com.javarush.helper.YamlOrganism;

import java.util.Map;

public class Boa extends Predator {
    public Boa(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed, int energy, double foodForLife, Map<String, Integer> eatingMap) {
        super(monitor, name, icon, weight, maxCountOnCell, speed, energy, foodForLife, eatingMap);
    }

    public Boa(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
