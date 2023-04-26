package com.javarush.utils;

import com.javarush.entity.islandModel.IslandMap;
import com.javarush.entity.islandModel.Location;
import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.settings.Settings;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Formatter {

    public static void showStatisticsOfIsland(IslandMap islandMap) {

        System.out.println("It's a new dawn it's a new day it's a new life! \uD83C\uDFDD\uFE0F\uD83C\uDF1E\uD83C\uDF31 ");
        Location[][] locations = islandMap.getLocations();
        for (int i = 0; i < Settings.X_POSITION; i++) {
            for (int j = 0; j < Settings.Y_POSITION; j++) {
                System.out.print("\n\uD83C\uDF40" + String.format("cell[%d][%d] = ", i, j));
                Location location = locations[i][j];
                List<BasalOrganism> animals = location.getAnimals();
                Map<BasalOrganism, Long> objectCounts = animals.stream()
                        .collect(Collectors.groupingBy(animal -> animal, Collectors.counting()));
                objectCounts.forEach((s, aLong) -> System.out.print(String.format("{%s %s = %d}", s.getIcon(), s.getName(), aLong)));
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("It's a calm night, it's a peaceful sleep, it's a time to rest... \uD83C\uDF1A\uD83C\uDFDD\uFE0F\uD83C\uDF1F\uD83E\uDD89");
        System.out.println("===========================================================================");
        System.out.println();

    }
}
