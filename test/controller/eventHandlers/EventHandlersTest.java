package controller.eventHandlers;

import controller.AbstractControllerTest;
import model.Tactician;
import model.items.Darkness;
import model.items.Spear;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EventHandlersTest extends AbstractControllerTest {

    @Test
    void AttackedUnitDefeatedHandler(){
        testItem3 = new Darkness("a2", 100,2,6);
        setUp3();
        setUp2();
        controller.initGame(2);
        controller.endTurn();
        controller.selectUnitIn(1,0);
        controller.equipItem(0);
        assertTrue(testPlayer1.getUnits().contains(testUnit2));
        assertEquals(testUnit2,controller.getGameMap().getCell(2,2).getUnit());
        controller.useItemOn(2,2);
        assertNull(controller.getGameMap().getCell(2,2).getUnit());
        assertFalse(testPlayer1.getUnits().contains(testUnit2));



    }

    @Test
    void PlayerDefeatedHandler(){
        testItem3 = new Darkness("a2", 100,2,6);
        setUp3();
        setUp2();
        controller.selectUnitIn(0,0);
        controller.equipItem(0);
        testUnit3.setEquippedItem(testItem3); //equip sorcerer
        Tactician defeatedPlayer = controller.getTurnOwner();
        assertTrue(defeatedPlayer.getSelectedUnit().gameChanger());
        assertTrue(controller.getTacticians().contains(defeatedPlayer));

        controller.useItemOn(1,0);
        assertEquals(85, controller.getGameMap().getCell(1,0).getUnit().getCurrentHitPoints());
        assertFalse(controller.getCurrentRoundOrder().contains(defeatedPlayer));  //defeated hero

        testItem1 = new Spear("a1",100,1,3);
        setUp3();
        setUp2();
        controller.selectUnitIn(0,0);
        controller.equipItem(0);
        testUnit3.setEquippedItem(testItem3); //equip sorcerer
        defeatedPlayer = controller.getCurrentRoundOrder().get(1);
        assertEquals(100, controller.getGameMap().getCell(1,0).getUnit().getCurrentHitPoints());
        assertTrue(controller.getCurrentRoundOrder().contains(defeatedPlayer));
        controller.useItemOn(1,0);
        assertFalse(controller.getCurrentRoundOrder().contains(defeatedPlayer));  //defeated hero
    }

    @Test
    void SelectedUnitDefeatedHandler(){

        testItem3 = new Darkness("a2", 10,1,6);
        testItem1 = new Spear("a1",100,1,3);
        setUp3();
        setUp2();
        ArrayList<IUnit> unitsT2 = new ArrayList<>();
        unitsT2.add(testUnit4);
        testPlayer2.setUnits(unitsT2);
        controller.initGame(2);
        controller.selectUnitIn(0,0);
        controller.equipItem(0);
        controller.endTurn();
        controller.selectUnitIn(1,0);
        controller.equipItem(0);
        assertEquals(2, testPlayer2.getUnits().size());
        assertTrue(testPlayer2.getUnits().contains(testUnit3));
        assertEquals(testUnit3,controller.getGameMap().getCell(1,0).getUnit());
        controller.useItemOn(0,0);
        assertEquals(1, testPlayer2.getUnits().size());
        assertNull(controller.getGameMap().getCell(1,0).getUnit());
        assertFalse(testPlayer2.getUnits().contains(testUnit3));
        assertTrue(controller.getCurrentRoundOrder().contains(testPlayer2));

    }

}
