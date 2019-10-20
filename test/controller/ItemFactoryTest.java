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
import model.items.*;
import model.map.Field;
import model.map.Location;
import model.units.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ItemFactoryTest {
    private IUnit testOwner = new Hero(4,7,new Location(5,3),new Spear("a",5,6,7));


    @Test
    void animaFactory(){
        ItemFactory animaFactory = new AnimaFactory();
        animaFactory.setHighRangeItem();
        animaFactory.setOwner(testOwner);
        IEquipableItem anima = animaFactory.createProduct();

        assertEquals(anima.getClass(), Anima.class);
        assertEquals(anima.getOwner(),testOwner);
        assertEquals(anima.getMaxRange(),6);


    }

    @Test
    void axeFactory(){
        ItemFactory axeFactory = new AxeFactory();
        axeFactory.setNormalItem();
        axeFactory.setOwner(testOwner);
        IEquipableItem axe = axeFactory.createProduct();

        assertEquals(axe.getClass(), Axe.class);
        assertEquals(axe.getOwner(),testOwner);
        assertEquals(axe.getPower(),15);
    }

    @Test
    void bowFactory(){
        ItemFactory bowFactory = new BowFactory();
        bowFactory.setHighRangeItem();
        bowFactory.setOwner(testOwner);
        IEquipableItem bow = bowFactory.createProduct();

        assertEquals(bow.getClass(), Bow.class);
        assertEquals(bow.getOwner(),testOwner);
        assertEquals(bow.getMaxRange(),6);
    }
    @Test
    void darknessFactory(){
        ItemFactory darknessFactory = new DarknessFactory();
        darknessFactory.setNormalItem();
        IEquipableItem darkness = darknessFactory.createProduct();

        assertEquals(darkness.getClass(), Darkness.class);
        assertNull(darkness.getOwner());
        assertEquals(darkness.getPower(),15);

    }
    @Test
    void lightFactory(){
        ItemFactory lightFactory = new LightFactory();
        lightFactory.setHighRangeItem();
        lightFactory.setOwner(testOwner);
        IEquipableItem light = lightFactory.createProduct();

        assertEquals(light.getClass(),Light.class);
        assertEquals(light.getOwner(),testOwner);
        assertEquals(light.getMaxRange(),6);

    }
    @Test
    void spearFactory(){
        ItemFactory spearFactory = new SpearFactory();
        spearFactory.setStrongItem();
        spearFactory.setOwner(testOwner);
        IEquipableItem spear = spearFactory.createProduct();

        assertEquals(spear.getClass(), Spear.class);
        assertEquals(testOwner, spear.getOwner());
        assertEquals(spear.getPower(),25);
    }
    @Test
    void staffMasterFactory(){
        ItemFactory staffFactory = new StaffFactory();
        staffFactory.setHighRangeItem();
        staffFactory.setOwner(testOwner);
        IEquipableItem staff = staffFactory.createProduct();

        assertEquals(staff.getClass(), Staff.class);
        assertEquals(staff.getOwner(),testOwner);
        assertEquals(staff.getName(),"High-range Staff");
    }

    @Test
    void swordMasterFactory(){
        ItemFactory swordFactory = new SwordFactory();
        swordFactory.setNormalItem();
        IEquipableItem sword = swordFactory.createProduct();

        assertEquals(sword.getClass(), Sword.class);
        assertNull(sword.getOwner());
        assertEquals(sword.getName(),"Normal Sword");
    }

}
