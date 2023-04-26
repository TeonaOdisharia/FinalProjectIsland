package com.javarush.entity.organisms.animals.predators;

import com.javarush.entity.organisms.animals.herbivores.Herbivore;
import com.javarush.helper.YamlOrganism;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class Bear extends Predator {
    public Bear(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
