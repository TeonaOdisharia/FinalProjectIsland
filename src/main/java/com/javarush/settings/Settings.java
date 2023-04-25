package com.javarush.settings;

import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.exceptions.IslandException;
import com.javarush.helper.ClassFinder;
import com.javarush.helper.YamlOrganism;
import com.javarush.utils.YamlReader;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Settings {
    public static final double MAX_AMOUNT_OF_PLANT_ON_ONE_CELL = 200;
    public static final double GROWTH_OF_PLANT = 20;
    public static final int Y_POSITION = 2;
    public static final int X_POSITION= 5;
    public static final int DURATION = 200;
    public static final int NUMBER_OF_SIMULATION = 30;
    private static final String SETTINGS_FILE = "organismsSettings.yaml";

    public static final Map<Class<? extends BasalOrganism>, double[]> BASIC_PARAMETERS_OF_ORGANISMS = new HashMap<>();

    public static List<BasalOrganism> generateObjectsByParameters() {
        List<BasalOrganism> createdObjects = new ArrayList<>();
        List<YamlOrganism> organisms = YamlReader.readYamlFile(SETTINGS_FILE);
        for (YamlOrganism yamlOrganism : organisms) {
            try {
                Class<?> classByName = ClassFinder.findClassByName(yamlOrganism.getName());
                Constructor<?> constructor = classByName.getConstructor(YamlOrganism.class);
                BasalOrganism instance = (BasalOrganism) constructor.newInstance(yamlOrganism);
                createdObjects.add(instance);
            } catch (ClassNotFoundException e) {
                throw new IslandException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return createdObjects;
    }
}
