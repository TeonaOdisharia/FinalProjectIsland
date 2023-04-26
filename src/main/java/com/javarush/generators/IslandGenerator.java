package com.javarush.generators;

import com.javarush.entity.islandModel.IslandMap;
import com.javarush.entity.islandModel.Location;
import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.helper.ClassFinder;
import com.javarush.settings.Settings;
import com.javarush.utils.CSVReader;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.javarush.utils.textReader.readLines;

@Getter
public class IslandGenerator {
    private final IslandMap islandMap;

    public IslandGenerator(int x, int y) {
        this.islandMap = new IslandMap(x, y);
        generateLocation();
        initLocation();
    }

    public void initLocation() {
        Location[][] locations = islandMap.getLocations();
        for (int i = 0; i < locations.length * locations[0].length; i++) {
            locations[i / locations[0].length][i % locations[0].length].start();
        }
    }

    public void generateLocation() {
        Location[][] locations = islandMap.getLocations();
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                Location location = new Location(i, j);
                locations[i][j] = location;
                generateOrganisms(location);
            }
        }
//        for (int i = 0; i < locations.length * locations[0].length; i++) {
//            Location location = locations[i / locations[0].length][i % locations[0].length];
//
//            generateOrganisms(location);
//        }
    }

    private void generateOrganisms(Location location) {
        List<BasalOrganism> basalOrganisms = Settings.generateObjectsByParameters();
        generateEatingMenu(basalOrganisms);
        location.setAnimals(basalOrganisms);
    }

    private void generateEatingMenu(List<BasalOrganism> basalOrganisms) {

        List<String[]> lists = CSVReader.readCSV("eatingProperties.csv", ",");
        Map<String, Map<String, Integer>> generateDataMap = CSVReader.generateDataMap(lists);

        for (BasalOrganism basalOrganism : basalOrganisms) {
            basalOrganism.setMealList(generateDataMap.getOrDefault(basalOrganism.getName(), null));
        }
    }
}
