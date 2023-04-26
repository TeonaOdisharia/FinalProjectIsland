package com.javarush.helper;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.*;

public class ClassFinder {

    public static Map<String, Class<?>> findClassByName(List<String> classNames) {
        Map<String, Class<?>> classesByName = new HashMap<>();

        List<String> packageNames = new ArrayList<>();
        packageNames.add("com.javarush.entity.organisms.animals.predators");
        packageNames.add("com.javarush.entity.organisms.plants");
        packageNames.add("com.javarush.entity.organisms.animals.omnivores");
        packageNames.add("com.javarush.entity.organisms.animals.herbivores");

        for (String packageName : packageNames) {
            Reflections reflections = new Reflections(new ConfigurationBuilder()
                    .setUrls(ClasspathHelper.forPackage(packageName))
                    .setScanners(new SubTypesScanner(false)));

            Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);

            for (String className : classNames) {
                for (Class<?> clazz : classes) {
                    if (clazz.getSimpleName().equals(className)) {
//                        System.out.println("Class found: " + clazz.getName());
                        classesByName.put(className, clazz);
                    }
                }
            }
        }
        return classesByName;
    }
}