package com.javarush.entity.organisms.animals.herbivores;

import com.javarush.entity.organisms.animals.predators.Predator;
import com.javarush.helper.YamlOrganism;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class Buffalo extends Herbivore {
    public Buffalo(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed) {
        super(monitor, name, icon, weight, maxCountOnCell, speed);
    }

    public Buffalo(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
