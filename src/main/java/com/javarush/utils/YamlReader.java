package com.javarush.utils;

import com.javarush.entity.organisms.BasalOrganism;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.*;

public class YamlReader {

    public static Map<Class<? extends BasalOrganism>, double[]> readYamlFile(String filePath) {
        InputStream inputStream = YamlReader.class.getClassLoader().getResourceAsStream(filePath);
        Yaml yaml = new Yaml();
        Map<Class<? extends BasalOrganism>, double[]> basicParametersOfOrganisms = new HashMap<>();
        for (Object object : yaml.loadAll(inputStream)) {
            Map<String, Object> map = (Map<String, Object>) object;
            Class<? extends BasalOrganism> clazz = (Class<? extends BasalOrganism>) map.get("name");
            double[] parameters = new double[]{
                    (double) map.get("weight"),
                    (double) map.get("max_num"),
                    (double) map.get("icon"),
                    (double) map.getOrDefault("movement_speed", 0.0),
                    (double) map.getOrDefault("satiation", 0.0)
            };
            basicParametersOfOrganisms.put(clazz, parameters);
        }
        return basicParametersOfOrganisms;
    }
}