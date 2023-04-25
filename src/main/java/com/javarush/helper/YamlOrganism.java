package com.javarush.helper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YamlOrganism {
    private String name;
    private double weight;
    private int max_num;
    private int movement_speed;
    private int satiation;
    private String icon;
}
