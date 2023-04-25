package com.javarush.generators;

import com.javarush.entity.islandModel.IslandMap;
import com.javarush.entity.islandModel.Location;

public class IslandGenerator {
    private final IslandMap islandMap;

    public IslandGenerator(int x, int y) {
        this.islandMap = new IslandMap(x, y);
        initLocation();
    }

    public void initLocation() {
        Location[][] locations = islandMap.getLocations();
        for (int y = 0; y < locations[y].length; y++) {
            for (int x = 0; x < locations.length; x++) {
                locations[x][y] = new Location(y, x);
            }
        }
    }

    public void generateNewWorld(){
        Location[][] locations = islandMap.getLocations();
        for (int y = 0; y < locations[y].length; y++) {
            for (int x = 0; x < locations.length; x++) {
                generateNearbyLocations();
                initOrganismsSet();
                generateOrganisms();
            }
        }
    }

    private void generateNearbyLocations() {
    }

    private void initOrganismsSet() {
    }

    private void generateOrganisms() {
        
    }
}
