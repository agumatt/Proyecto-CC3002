package controller;

import model.Tactician;
import model.items.Darkness;
import model.items.IEquipableItem;
import model.items.Spear;
import model.items.Sword;
import model.units.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractControllerTest {

    protected GameController controller;
    protected long randomSeed;
    protected List<String> testTacticians;
    protected IEquipableItem testItem1 = new Spear("a1",10,1,3);
    protected IEquipableItem testItem2 = new Sword("b1", 10,1,2);
    protected IEquipableItem testItem3 = new Darkness("a2", 20,2,6);
    protected IUnit testUnit1;
    protected IUnit testUnit2;
    protected IUnit testUnit3;
    protected IUnit testUnit4;
    protected Tactician testPlayer1;
    protected Tactician testPlayer2;


    protected void setUp2(){
        testUnit1 = new Hero(100,2,controller.getGameMap().getCell(0,0),testItem1,testItem2);
        testUnit2 = new Cleric(100,2,controller.getGameMap().getCell(2,2));
        testUnit3 = new Sorcerer(100,2,controller.getGameMap().getCell(1,0),testItem3);
        testUnit4 = new Fighter(100,2,controller.getGameMap().getCell(2,3));

        testPlayer1 = controller.getCurrentRoundOrder().get(0);
        testPlayer2 = controller.getCurrentRoundOrder().get(1);

        ArrayList<IUnit> unitsT1 = new ArrayList<>();
        unitsT1.add(testUnit1);
        unitsT1.add(testUnit2);
        ArrayList<IUnit> unitsT2 = new ArrayList<>();
        unitsT2.add(testUnit3);
        testPlayer1.setUnits(unitsT1);
        testPlayer2.setUnits(unitsT2);


    }


    protected void setUp3(){
        controller = new GameController(4,3,true);
        randomSeed = controller.getSeed();
    }



}
