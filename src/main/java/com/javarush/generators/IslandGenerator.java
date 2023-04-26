package com.javarush.generators;

import com.javarush.entity.islandModel.IslandMap;
import com.javarush.entity.islandModel.Location;
import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.settings.Settings;
import lombok.Getter;

import java.util.List;

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
        for (int i = 0; i < locations.length * locations[0].length; i++) {
            Location location = locations[i / locations[0].length][i % locations[0].length];
            generateOrganisms(location);
        }
    }

    private void generateOrganisms(Location location) {
        List<BasalOrganism> basalOrganisms = Settings.generateObjectsByParameters();
        location.setAnimals(basalOrganisms);
    }
}
