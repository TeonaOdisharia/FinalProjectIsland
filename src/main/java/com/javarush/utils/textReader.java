package com.javarush.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class textReader {
    public static void main(String[] args) {
        String[] strings = readLines("eatingProperties.csv");
        for (String string : strings) {
            System.out.println(string);
        }
    }
    public static String[] readLines(String fileName) {
        List<String> names = new ArrayList<>();
        InputStream inputStream = textReader.class.getClassLoader().getResourceAsStream(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading names from the file", e);
        }
        return names.toArray(new String[0]);
    }
}