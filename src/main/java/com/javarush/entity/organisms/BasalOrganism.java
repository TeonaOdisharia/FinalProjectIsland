package com.javarush.entity.organisms;

import com.javarush.entity.islandModel.Location;
import com.javarush.helper.YamlOrganism;
import com.javarush.service.OrganismsBehaviors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BasalOrganism implements OrganismsBehaviors {
    Object monitor;
    private String name;
    private String icon;
    private double weight;
    private int maxCountOnCell;
    private int speed;
    private int satiation;
    private Map<String, Integer> mealList;

    protected Class<? extends BasalOrganism> aClass;
    private final Lock lock = new ReentrantLock(true);

    private int yamlOrganism;

    public BasalOrganism(Object monitor, String name, String icon, double weight, int maxCountOnCell, int speed) {
        this.monitor = monitor;
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.maxCountOnCell = maxCountOnCell;
        this.speed = speed;
    }

    public BasalOrganism(BasalOrganism animal, Location location) {

    }

    public BasalOrganism(YamlOrganism yamlOrganism) {
        this.name = yamlOrganism.getName();
        this.icon = yamlOrganism.getIcon();
        this.weight = yamlOrganism.getWeight();
        this.maxCountOnCell = yamlOrganism.getMax_num();
        this.speed = yamlOrganism.getMovement_speed();
        this.satiation = yamlOrganism.getMovement_speed();
        this.monitor = this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasalOrganism that = (BasalOrganism) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
