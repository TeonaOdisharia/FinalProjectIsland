package com.javarush.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.*;

@Getter
@Setter
public class CSVReader {

    public static List<String[]> readCSV(String csvFile, String csvSeparator) {
        List<String[]> data = new ArrayList<>();
        InputStream inputStream = textReader.class.getClassLoader().getResourceAsStream(csvFile);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(csvSeparator);
                data.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading names from the file", e);
        }
        return data;
    }

    public static Map<String, Map<String, Integer>> generateDataMap(List<String[]> data) {
        Map<String, Map<String, Integer>> eatingMenuMap = new HashMap<>();
        Map<String, Integer> innerMap = new HashMap<>();
        String[] animalsArr;
        if (data.size() > 0) {
            animalsArr = data.get(0);
            for (int i = 1; i < data.size(); i++) {
                String[] victims = data.get(i);
                for (int j = 1; j < victims.length; j++) {
                    String victim = victims[j];
                    String victimName = animalsArr[j - 1];
                    int victimPercentage = Integer.parseInt(victim);
                    innerMap.put(victimName, victimPercentage);
                }
                if (innerMap.size() > 0) {
                    eatingMenuMap.put(victims[0], innerMap) ;
                }
            }
        }
        return eatingMenuMap;
    }
}