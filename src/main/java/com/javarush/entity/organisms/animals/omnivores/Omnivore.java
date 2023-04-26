package com.javarush.entity.organisms.animals.omnivores;

import com.javarush.entity.organisms.animals.Animal;
import com.javarush.helper.YamlOrganism;

import java.util.Map;

public abstract class Omnivore extends Animal {
    public Omnivore(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed) {
        super(monitor, name, icon, weight, maxCountOnCell, speed);
    }

    public Omnivore(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
