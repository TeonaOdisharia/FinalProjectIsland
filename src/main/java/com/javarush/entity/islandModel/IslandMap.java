package com.javarush.entity.islandModel;

public class IslandMap {
    private final Location[][] locations;

    public IslandMap(int i, int j) {
        this.locations = new Location[i][j];
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void showIsland() {
        System.out.println("A world born anew \uD83C\uDFDD\uFE0F ");
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations.length; j++) {
                Location[] location = locations[j];
                System.out.print(locations[i][j]);
            }
            System.out.println();
        }
        System.out.println("The final curtain falls \uD83D\uDC94");
        System.out.println("============================================");
    }
}
