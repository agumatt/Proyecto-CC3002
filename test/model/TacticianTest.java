package model;

import model.items.*;
import model.map.Field;
import model.map.Location;
import model.units.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TacticianTest {

    private IEquipableItem testItem1;
    private IEquipableItem testItem2;
    private IEquipableItem testItem3;
    private IEquipableItem testItem4;
    private IUnit testUnit1;
    private IUnit testUnit2;
    private IUnit testUnit3;
    private Field field;
    private Tactician testPlayer1;
    private Tactician testPlayer2;


    @BeforeEach
    void setUp(){
        testItem1 = new Spear("a1",10,1,3);
        testItem2 = new Sword("b2", 10,1,2);
        testItem3 = new Darkness("a2", 20,2,6);
        testItem4 = new Bow("b2", 100,2,10);
        field = new Field();
        field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
                new Location(0, 3),new Location(0, 4),new Location(1, 0), new Location(1, 1), new Location(1, 2),new Location(1, 3), new Location(1, 4),new Location(2, 0),
                new Location(2, 1), new Location(2, 2),new Location(2, 3),new Location(2, 4),new Location(2, 5),new Location(2, 6),
                new Location(2, 7),new Location(2, 8));
        testUnit1 = new Hero(100,2,field.getCell(0,0),testItem1,testItem2);
        testUnit2 = new Cleric(100,2,field.getCell(2,2));
        testUnit3 = new Sorcerer(100,2,field.getCell(1,0),testItem3);

        testPlayer1 = new Tactician("Player 1");
        testPlayer2 = new Tactician("Player 2");


    }

    void setUnits(){
        ArrayList<IUnit> unitsT1 = new ArrayList<>();
        unitsT1.add(testUnit1);
        unitsT1.add(testUnit2);
        ArrayList<IUnit> unitsT2 = new ArrayList<>();
        unitsT2.add(testUnit3);
        testPlayer1.setUnits(unitsT1);
        testPlayer2.setUnits(unitsT2);

    }

    @Test
    public void constructorTest() {
        assertEquals("Player 1", testPlayer1.getName());
        assertEquals("Player 2", testPlayer2.getName());
        assertNull(testPlayer1.getSelectedUnit());
        assertTrue(testPlayer2.getUnits().isEmpty());

    }


    @Test
    void basicTest(){
        setUnits();
        testPlayer1.setSelectedUnit(testPlayer1.getUnits().get(0));
        assertEquals(2,testPlayer1.getMovement());
        assertEquals(100,testPlayer1.getCurrentHitPoints());
        assertEquals(100,testPlayer1.getMaxHitPoints());
        testPlayer1.setCurrentHitPoints(50);
        assertEquals(50,testPlayer1.getCurrentHitPoints());
    }

    @Test
    public void getUnitsTest() {
        assertTrue(testPlayer1.getUnits().isEmpty());
        ArrayList<IUnit> unitsT = new ArrayList<>();
        unitsT.add(testUnit1);
        unitsT.add(testUnit2);
        testPlayer1.setUnits(unitsT);
        assertTrue(testPlayer1.getUnits().size()==2);
        assertTrue(testPlayer1.getUnits().containsAll(unitsT));

    }




    @Test
    public void getSelectedUnit(){
        setUnits();
        testPlayer1.setSelectedUnit(testPlayer1.getUnits().get(0));
        assertEquals(testUnit1,testPlayer1.getSelectedUnit());
        testPlayer2.setSelectedUnit(testPlayer1.getUnits().get(0));  //set unit thats already owned
        assertNull(testPlayer2.getSelectedUnit());

    }
    /**
     * Checks if the axe is equipped correctly to the unit
     */
    @Test
    public void equipItemTest() {
        setUnits();
        testPlayer1.setSelectedUnit(testPlayer1.getUnits().get(0));
        assertNull(testUnit1.getEquippedItem());
        assertNull(testPlayer1.getEquippedItem());
        testPlayer1.setEquippedItem(testItem1);
        assertEquals(testItem1,testUnit1.getEquippedItem());
        assertEquals(testItem1,testPlayer1.getEquippedItem());
    }



    /**
     * Checks if the unit moves correctly
     */
    @Test
    public void testMovement() {
        setUnits();
        testPlayer1.setSelectedUnit(testPlayer1.getUnits().get(0));
        testPlayer1.moveTo(field.getCell(2, 2));
        assertEquals(new Location(0, 0), testPlayer1.getLocation());
        testPlayer2.setSelectedUnit(testPlayer2.getUnits().get(0));
        testPlayer2.moveTo(field.getCell(0, 2));
        assertNotEquals(new Location(0, 2), testPlayer2.getLocation());
        testPlayer2.moveTo(field.getCell(1, 2));
        assertEquals(new Location(1, 2), testPlayer2.getLocation());
            }
    @Test
    void getSelectedItem(){
        setUnits();
        testPlayer1.setSelectedUnit(testPlayer1.getUnits().get(0));
        assertNull(testPlayer1.getSelectedItem());
        testPlayer1.setSelectedItem(testItem1);
        assertEquals(testItem1,testPlayer1.getSelectedItem());

    }

    @Test
    void equipItem(){
        setUnits();
        testPlayer1.setSelectedUnit(testPlayer1.getUnits().get(0));
        assertNull(testUnit1.getEquippedItem());
        assertNull(testPlayer1.getEquippedItem());
        testPlayer1.equipItem(testItem1);
        assertEquals(testUnit1.getEquippedItem(),testPlayer1.getEquippedItem());
    }


    @Test
    void getItems(){
        setUnits();
        testPlayer1.setSelectedUnit(testPlayer1.getUnits().get(0));
        assertEquals(2,testPlayer1.getItems().size());
        assertTrue(testPlayer1.getItems().containsAll(Arrays.asList(testItem1,testItem2)));

    }

    @Test
    void giveItemTo(){
        setUnits();
        testPlayer1.setSelectedUnit(testPlayer1.getUnits().get(0));
        assertTrue(!testPlayer2.getUnits().get(0).getItems().contains(testItem1));
        testPlayer1.setSelectedItem(testItem1);
        testPlayer1.giveItemTo(testPlayer2.getUnits().get(0),testPlayer1.getSelectedItem());
        assertTrue(testPlayer2.getUnits().get(0).getItems().contains(testItem1));
    }

    @Test
    void getLocation(){
        setUnits();
        testPlayer1.setSelectedUnit(testPlayer1.getUnits().get(0));
        assertEquals(new Location(0,0),testPlayer1.getLocation());
        testPlayer1.setLocation(field.getCell(2,7));
        assertEquals(field.getCell(2,7),testUnit1.getLocation());
        assertEquals(field.getCell(2,7).getUnit(),testUnit1);
    }

    @Test
    public void testUseEquippedItem(){
        setUnits();
        testPlayer1.setSelectedUnit(testPlayer1.getUnits().get(0));
        testPlayer2.setSelectedUnit(testPlayer2.getUnits().get(0));
        testPlayer1.setEquippedItem(testItem1);
        testPlayer2.setEquippedItem(testItem3);
        assertEquals(100,testPlayer1.getCurrentHitPoints());
        assertEquals(100,testPlayer2.getCurrentHitPoints());
        testPlayer1.useEquippedItem(testPlayer2.getUnits().get(0));
        assertEquals(70,testPlayer1.getCurrentHitPoints());
        assertEquals(85,testPlayer2.getCurrentHitPoints());

        Tactician testPlayer3 = new Tactician("Player 3");
        IUnit testUnit4 = new Archer(100,2,field.getCell(2,1),testItem4);
        ArrayList<IUnit> unit = new ArrayList<>();
        unit.add(testUnit4);
        testPlayer3.setUnits(unit);
        testPlayer3.setSelectedUnit(testPlayer3.getUnits().get(0));
        testPlayer3.setEquippedItem(testItem4);
        testPlayer3.useEquippedItem(testPlayer1.getUnits().get(0));
        assertTrue(testUnit1.getCurrentHitPoints()<=0);



    }



    @Test
    void removeUnit(){
        setUnits();
        assertEquals(2,testPlayer1.getUnits().size());
        assertTrue(testPlayer1.getUnits().contains(testUnit2));
        testPlayer1.removeUnit(testUnit2);
        assertEquals(1, testPlayer1.getUnits().size());
        assertFalse(testPlayer1.getUnits().contains(testUnit2));
    }


}
