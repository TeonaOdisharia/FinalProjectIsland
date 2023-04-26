package com.javarush.entity.organisms.animals.omnivores;

import com.javarush.helper.YamlOrganism;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class Caterpillar extends Omnivore {
    public Caterpillar(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed) {
        super(monitor, name, icon, weight, maxCountOnCell, speed);
    }

    public Caterpillar(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
