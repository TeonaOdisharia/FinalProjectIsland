package com.javarush.entity.organisms.plants;

import com.javarush.entity.islandModel.Location;
import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.helper.YamlOrganism;

public class Coconut extends Plant{
    public Coconut(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed) {
        super(monitor, name, icon, weight, maxCountOnCell, speed);
    }

    public Coconut(BasalOrganism animal, Location location) {
        super(animal, location);
    }

    public Coconut(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
