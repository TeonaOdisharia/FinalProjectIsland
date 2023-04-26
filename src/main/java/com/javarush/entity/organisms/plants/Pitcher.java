package com.javarush.entity.organisms.plants;

import com.javarush.entity.organisms.animals.predators.Predator;
import com.javarush.helper.YamlOrganism;

import java.util.Map;

public class Pitcher extends Predator {
    public Pitcher(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed, int energy, double foodForLife, Map<String, Integer> eatingMap) {
        super(monitor, name, icon, weight, maxCountOnCell, speed, energy, foodForLife, eatingMap);
    }

    public Pitcher(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
