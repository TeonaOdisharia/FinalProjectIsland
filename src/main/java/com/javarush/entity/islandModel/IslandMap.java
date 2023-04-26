package com.javarush.entity.islandModel;

import com.javarush.utils.Formatter;

public class IslandMap {
    private final Location[][] locations;

    public IslandMap(int i, int j) {
        this.locations = new Location[i][j];
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void showIsland() {
        Formatter.showStatisticsOfIsland(this);

    }
}
