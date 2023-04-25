package com.javarush.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class CSVReader {

    public static List<List<String>> readCSV(String csvFile, String csvSeparator) {
        List<List<String>> data = new ArrayList<>();
        InputStream inputStream = textReader.class.getClassLoader().getResourceAsStream(csvFile);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> row = Arrays.asList(line.split(csvSeparator));
                data.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading names from the file", e);
        }
        return data;
    }
}
