package com.javarush.entity.organisms.plants;

import com.javarush.entity.organisms.animals.predators.Predator;
import com.javarush.helper.YamlOrganism;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class Pitcher extends Predator {

    public Pitcher(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
