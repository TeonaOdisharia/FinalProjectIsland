package com.javarush.entity.organisms.animals.predators;

import com.javarush.helper.YamlOrganism;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class Boa extends Predator {

    public Boa(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
