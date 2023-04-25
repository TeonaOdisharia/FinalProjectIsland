package com.javarush;

import com.javarush.entity.organisms.BasalOrganism;
import com.javarush.generators.IslandGenerator;
import com.javarush.helper.YamlOrganism;
import com.javarush.service.IslandTask;
import com.javarush.settings.Settings;
import com.javarush.utils.YamlReader;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {

        IslandGenerator island = new IslandGenerator(Settings.Y_POSITION, Settings.X_POSITION);
        IslandTask islandTask = new IslandTask(island);
        islandTask.start();

    }
}
