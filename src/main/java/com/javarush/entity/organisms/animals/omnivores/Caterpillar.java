package com.javarush.entity.organisms.animals.omnivores;

import com.javarush.helper.YamlOrganism;

import java.util.Map;

public class Caterpillar extends Omnivore {
    public Caterpillar(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed, int energy, double foodForLife, Map<String, Integer> eatingMap) {
        super(monitor, name, icon, weight, maxCountOnCell, speed, energy, foodForLife, eatingMap);
    }

    public Caterpillar(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
