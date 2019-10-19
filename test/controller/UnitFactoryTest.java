package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Array;
import java.util.*;
import java.util.stream.IntStream;

import controller.Factory.*;
import model.Tactician;
import model.items.Axe;
import model.items.Bow;
import model.items.IEquipableItem;
import model.items.Sword;
import model.map.Field;
import model.map.Location;
import model.units.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UnitFactoryTest {
    private ArrayList<IEquipableItem> testItem =
            new ArrayList<>(Arrays.asList(new Axe("Test Axe",4,2,3)));
    private Location testLocation = new Location(0,0);


    @Test
    public void alpacaFactory(){
        UnitFactory alpacaFactory = new AlpacaFactory();
        alpacaFactory.setDurableUnit();
        alpacaFactory.setItems(testItem);
        alpacaFactory.setLocation(testLocation);
        IUnit alpaca = alpacaFactory.createProduct();

        assertEquals(alpaca.getClass(),Alpaca.class);
        assertEquals(alpaca.getLocation(),testLocation);
        assertEquals(alpaca.getItems().get(0),testItem.get(0));
        assertEquals(alpaca.getMaxHitPoints(),100);


    }

    @Test
    public void archerFactory(){
        UnitFactory archerFactory = new ArcherFactory();
        archerFactory.setDurableUnit();
        archerFactory.setItems(testItem);
        archerFactory.setLocation(testLocation);
        IUnit archer = archerFactory.createProduct();

        assertEquals(archer.getClass(), Archer.class);
        assertEquals(archer.getLocation(),testLocation);
        assertEquals(archer.getItems().get(0),testItem.get(0));
        assertEquals(archer.getMaxHitPoints(),100);
    }

    @Test
    public void clericFactory(){
        UnitFactory clericFactory = new ClericFactory();
        clericFactory.setDurableUnit();
        clericFactory.setItems(testItem);
        clericFactory.setLocation(testLocation);
        IUnit cleric = clericFactory.createProduct();

        assertEquals(cleric.getClass(), Cleric.class);
        assertEquals(cleric.getLocation(),testLocation);
        assertEquals(cleric.getItems().get(0),testItem.get(0));
        assertEquals(cleric.getMaxHitPoints(),100);
    }
    @Test
    public void fighterFactory(){
        UnitFactory fighterFactory = new FighterFactory();
        fighterFactory.setNormalUnit();
        fighterFactory.setItems(testItem);
        fighterFactory.setLocation(testLocation);
        IUnit fighter = fighterFactory.createProduct();

        assertEquals(fighter.getClass(), Fighter.class);
        assertEquals(fighter.getLocation(),testLocation);
        assertEquals(fighter.getItems().get(0),testItem.get(0));
        assertEquals(fighter.getMaxHitPoints(),75);

    }
    @Test
    public void heroFactory(){
        UnitFactory heroFactory = new HeroFactory();
        heroFactory.setDurableUnit();
        heroFactory.setItems(testItem);
        heroFactory.setLocation(testLocation);
        IUnit hero = heroFactory.createProduct();

        assertEquals(hero.getClass(),Hero.class);
        assertEquals(hero.getLocation(),testLocation);
        assertEquals(hero.getItems().get(0),testItem.get(0));
        assertEquals(hero.getMaxHitPoints(),100);

    }
    @Test
    public void sorcererFactory(){
        UnitFactory sorcererFactory = new SorcererFactory();
        sorcererFactory.setWeakUnit();
        sorcererFactory.setItems(testItem);
        sorcererFactory.setLocation(testLocation);
        IUnit sorcerer = sorcererFactory.createProduct();

        assertEquals(sorcerer.getClass(),Sorcerer.class);
        assertEquals(sorcerer.getLocation(),testLocation);
        assertEquals(sorcerer.getItems().get(0),testItem.get(0));
        assertEquals(sorcerer.getMaxHitPoints(),50);
    }
    @Test
    public void swordMasterFactory(){
        UnitFactory swordMasterFactory = new SwordMasterFactory();
        swordMasterFactory.setNormalUnit();
        swordMasterFactory.setItems(testItem);
        swordMasterFactory.setLocation(testLocation);
        IUnit swordMaster = swordMasterFactory.createProduct();

        assertEquals(swordMaster.getClass(),SwordMaster.class);
        assertEquals(swordMaster.getLocation(),testLocation);
        assertEquals(swordMaster.getItems().get(0),testItem.get(0));
        assertEquals(swordMaster.getMaxHitPoints(),75);
    }

}
