package com.javarush.generators;

import com.javarush.entity.islandModel.IslandMap;
import com.javarush.entity.islandModel.Location;
import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.settings.Settings;
import com.javarush.utils.CSVReader;
import lombok.Getter;

import java.util.*;

@Getter
public class IslandGenerator {
    private final IslandMap islandMap;

    public IslandGenerator(int x, int y) {
        this.islandMap = new IslandMap(x, y);
        generateLocation();
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
                initNearbyLocations(location);
            }
        }
    }
    private void initNearbyLocations(Location location) {
        int yLeft = Math.max(location.getYPosition() - 1, 0);
        int xDown = Math.min(location.getXPosition() + 1, Settings.X_POSITION - 1);
        int yRight = Math.min(location.getYPosition() + 1, Settings.Y_POSITION - 1);
        int xUp = Math.max(location.getXPosition() - 1, 0);

        for (int i = xUp; i < xDown ; i++) {
            for (int j = yLeft; j < yRight; j++) {
                location.getNearbyLocations().add(islandMap.getLocation(i,j));
            }
        }
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
