package com.javarush.settings;

import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.utils.YamlReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Settings {
    public static final double MAX_AMOUNT_OF_PLANT_ON_ONE_CELL = 200;
    public static final double GROWTH_OF_PLANT = 20;
    public static final int SIZE_OF_GAME_FIELD_Y = 5;
    public static final int SIZE_OF_GAME_FIELD_X = 10;
    public static final int STEP_DURATION = 500;
    public static final int NUMBER_OF_SIMULATION_STEPS = 30;
    private static final String SETTINGS_FILE = "organismsSettings.yaml";

    public static final Map<Class<? extends BasalOrganism>, double[]> BASIC_PARAMETERS_OF_ORGANISMS = new HashMap<>();

    static {
//        BASIC_PARAMETERS_OF_ANIMALS.put(Bear.class, new double[]{500, 5, 2, 80});



    }

    public static Map<Class<? extends BasalOrganism>, double[]> generateParameters() {
//        Map<String, Object> yamlSettingMap = YamlReader.readYamlFile(SETTINGS_FILE);
        Map<Class<? extends BasalOrganism>, double[]> parameters = new HashMap<>();



//        for (BasalOrganism organism : organisms) {
//            String className = organism.getName();
//            Class<?> clazz;
//            try {
//                clazz = Class.forName("your.package.name." + className);
//            } catch (ClassNotFoundException e) {
//                System.err.println("Class not found: " + className);
//                e.printStackTrace();
//                continue;
//            }
//
//            if (!BasalOrganism.class.isAssignableFrom(clazz)) {
//                System.err.println("Invalid class: " + className);
//                continue;
//            }
//
//            double[] values = new double[]{
//                    organism.getWeight(),
//                    organism.getMax_num(),
//                    organism.getMovement_speed() != null ? organism.getMovement_speed() : 0,
//                    organism.getSatiation() != null ? organism.getSatiation() : 0
//            };
//            parameters.put(clazz.asSubclass(BasalOrganism.class), values);
//        }

        return parameters;
    }
}
