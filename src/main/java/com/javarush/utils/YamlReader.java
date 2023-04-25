package com.javarush.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.javarush.exceptions.IslandException;
import com.javarush.helper.YamlOrganism;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class YamlReader {

    public static List<YamlOrganism> readYamlFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        List<YamlOrganism> organisms;
        InputStream inputStream = YamlReader.class.getClassLoader().getResourceAsStream(filePath);
        try {
            organisms = objectMapper.readValue(inputStream,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, YamlOrganism.class));
        } catch (IOException e) {
            throw new IslandException(e);
        }

        return organisms;
    }

    public static void main(String[] args) {
        String filePath = "organismsSettings.yaml";


//        List<YamlOrganism> yamlOrganisms = YamlReader.readYamlFile("organismsSettings.yaml");
//
//        for (YamlOrganism organism : yamlOrganisms) {
//            System.out.println("Name: " + organism.getName());
//            System.out.println("Weight: " + organism.getWeight());
//            System.out.println("Max Num: " + organism.getMax_num());
//            System.out.println("Movement Speed: " + organism.getMovement_speed());
//            System.out.println("Satiation: " + organism.getSatiation());
//            System.out.println("Icon: " + organism.getIcon());
//            System.out.println("-------------------------------");
//        }

    }
}