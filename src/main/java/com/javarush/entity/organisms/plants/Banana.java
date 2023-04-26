package com.javarush.entity.organisms.plants;

import com.javarush.entity.islandModel.Location;
import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.helper.YamlOrganism;

public class Banana extends Plant{
    public Banana(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed) {
        super(monitor, name, icon, weight, maxCountOnCell, speed);
    }

    public Banana(BasalOrganism animal, Location location) {
        super(animal, location);
    }

    public Banana(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
