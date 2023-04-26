package com.javarush.entity.organisms.plants;

import com.javarush.entity.islandModel.Location;
import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.helper.YamlOrganism;

public abstract class Plant extends BasalOrganism {
    public Plant(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed) {
        super(monitor, name, icon, weight, maxCountOnCell, speed);
    }

    public Plant(BasalOrganism animal, Location location) {
        super(animal, location);
    }

    public Plant(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
