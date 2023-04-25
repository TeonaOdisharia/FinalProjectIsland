package com.javarush;

import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.utils.YamlReader;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        Map<Class<? extends BasalOrganism>, double[]> classMap = YamlReader.readYamlFile("organismsSettings.yaml");


    }

}
