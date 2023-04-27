package com.javarush.settings;

import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.entity.organisms.animals.predators.Predator;
import com.javarush.exceptions.IslandException;
import com.javarush.helper.ClassFinder;
import com.javarush.helper.Randomizer;
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
    public static final int X_POSITION = 5;
    public static final int Y_POSITION = 5;
    public static final int DURATION = 20;
    public static final int NUMBER_OF_SIMULATION = 30;
    public static final int AVAILABLE_CORES = Runtime.getRuntime().availableProcessors();
    private static final String SETTINGS_FILE = "organismsSettings.yaml";


    public static List<BasalOrganism> generateObjectsByParameters() {
        List<BasalOrganism> createdObjects = new ArrayList<>();
        List<YamlOrganism> organisms = YamlReader.readYamlFile(SETTINGS_FILE);
        List<String> classNames = new ArrayList<>();
        for (YamlOrganism organism : organisms) {
            classNames.add(organism.getName());
        }
        Map<String, Class<?>> classesByName = ClassFinder.findClassByName(classNames);

        for (YamlOrganism yamlOrganism : organisms) {
            int toBeOrNotToBe = Randomizer.getNumber(0, 2);
            if (toBeOrNotToBe == 0) {
                continue;
            }

            try {
                Class<?> classByName = classesByName.get(yamlOrganism.getName());
                if (classByName == null) {
                    continue;
                }

                Constructor<?> constructor = classByName.getConstructor(YamlOrganism.class);
                int counter = Randomizer.getNumber(0, yamlOrganism.getMax_num());
                for (int i = 0; i < counter; i++) {
                    BasalOrganism instance = (BasalOrganism) constructor.newInstance(yamlOrganism);
                    createdObjects.add(instance);
                }
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
