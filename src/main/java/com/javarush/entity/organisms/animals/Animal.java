package com.javarush.entity.organisms.animals;

import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.helper.YamlOrganism;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class Animal extends BasalOrganism {
    private int energy = 1;
    private double foodForLife;
    private Map<String, Integer> eatingMap;

    public Animal(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed) {
        super(monitor, name, icon, weight, maxCountOnCell, speed);
    }

    public Animal(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
