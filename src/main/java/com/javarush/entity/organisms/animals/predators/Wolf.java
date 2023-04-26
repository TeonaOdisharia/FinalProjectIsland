package com.javarush.entity.organisms.animals.predators;

import com.javarush.entity.organisms.animals.herbivores.Herbivore;
import com.javarush.helper.YamlOrganism;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class Wolf extends Predator {

    public Wolf(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed, int energy, double foodForLife, Map<String, Integer> eatingMap) {
        super(monitor, name, icon, weight, maxCountOnCell, speed, energy, foodForLife, eatingMap);
    }

    public Wolf(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
