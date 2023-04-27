package com.javarush;

import com.javarush.entity.islandModel.IslandMap;
import com.javarush.entity.islandModel.Location;
import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.generators.IslandGenerator;
import com.javarush.helper.StartSimulationWithoutMultithreading;
import com.javarush.helper.YamlOrganism;
import com.javarush.service.IslandTask;
import com.javarush.settings.Settings;
import com.javarush.utils.YamlReader;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        IslandGenerator island = new IslandGenerator(Settings.X_POSITION, Settings.Y_POSITION);

//        With Threads
        IslandTask islandTask = new IslandTask(island);
        islandTask.start();

//        //Without Threads, just loops
//        IslandMap islandMap = island.getIslandMap();
//        StartSimulationWithoutMultithreading.startSimulation(islandMap);
//        islandMap.showStatisticsOfIsland(1);

    }
}
