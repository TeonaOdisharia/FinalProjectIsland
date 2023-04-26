package com.javarush.entity.organisms.plants;

import com.javarush.entity.islandModel.Location;
import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.helper.YamlOrganism;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Grass extends Plant{
    public Grass(YamlOrganism yamlOrganism) {
        super(yamlOrganism);
    }
}
