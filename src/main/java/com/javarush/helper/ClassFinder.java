package com.javarush.helper;

import org.reflections.Reflections;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ClassFinder {
    public static Class<?> findClassByName(String className) throws ClassNotFoundException {
        Reflections reflections = new Reflections("");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith((Class<? extends Annotation>) Class.forName(className));

        if (classes.isEmpty()) {
            throw new ClassNotFoundException("Class not found: " + className);
        }

        return classes.iterator().next();
    }

    public static HashMap<String, String> getClasses(String rootPackage) throws IOException {
        HashMap<String, String> classes = new HashMap<>();

        File rootDir = new File(rootPackage);

        if (!rootDir.exists()) {
            throw new IOException("The root directory " + rootPackage + " does not exist.");
        }

        Scanner scanner = new Scanner(rootDir);

        while (scanner.hasNext()) {
            String filename = scanner.next();

            if (filename.endsWith(".class")) {
                String fullPath = rootPackage + "/" + filename;

                String className = filename.substring(0, filename.lastIndexOf('.'));

                classes.put(className, fullPath);
            }
        }

        scanner.close();

        return classes;
    }
}
