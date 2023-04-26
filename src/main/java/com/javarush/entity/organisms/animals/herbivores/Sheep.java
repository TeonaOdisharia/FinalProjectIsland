package com.javarush.entity.organisms.animals.herbivores;

import com.javarush.helper.YamlOrganism;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class Sheep extends Herbivore {

    public Sheep(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed) {
        super(monitor, name, icon, weight, maxCountOnCell, speed);
    }

    public Sheep(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
