package com.javarush.helper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class YamlOrganism {
    private String name;
    private double weight;
    private int max_num;
    private int movement_speed;
    private int satiation;
    private String icon;
}
