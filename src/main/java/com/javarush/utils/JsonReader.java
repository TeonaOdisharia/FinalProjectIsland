package com.javarush.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

public class JsonReader {

    public static List<Object> readJsonFile(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Object> objects = new ArrayList<>();

        File file = new File(filePath);
        if (!file.exists()) {
            throw new Exception("File not found");
        }

        List<Map<String, Object>> jsonObjects = mapper.readValue(file, List.class);
        for (Map<String, Object> jsonObject : jsonObjects) {
            String className = (String) jsonObject.get("name");
            Class<?> clazz = Class.forName(className);
            objects.add(clazz.newInstance());
        }

        return objects;
    }

    public static void main(String[] args) {
        try {
            JsonReader.readJsonFile("src/main/resources/organisms.json");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

