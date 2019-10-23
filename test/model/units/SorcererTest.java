package model.units;

import model.items.Anima;
import model.items.Darkness;
import model.items.Light;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SorcererTest extends AbstractTestUnit {


    private Sorcerer noCounterattackSorcerer;
    private Sorcerer secondSorcerer;
    private Darkness darkness2;
    private Darkness darkness3;
    private Light light2;
    private Light light3;
    private Anima anima2;
    private Anima anima3;

    /**
     * Set up the main unit that's going to be tested in the test set
     */

    public void setTestUnit(){
        sorcerer = new Sorcerer(1000, 2, field.getCell(0, 0));
        noCounterattackSorcerer = new Sorcerer(1, 2, field.getCell(1, 1));
        secondSorcerer = new Sorcerer(1, 2, field.getCell(2, 2));
        this.darkness2 = new Darkness("Darkness", 10, 1, 5);
        this.darkness3 = new Darkness("Darkness", 10, 1, 5);
        this.light2 = new Light("Light", 10, 1, 5);
        this.light3 = new Light("Light", 10, 1, 5);
        this.anima2 = new Anima("Anima", 10, 1, 5);
        this.anima3 = new Anima("Anima", 10, 1, 5);
        darkness2.setOwner(noCounterattackSorcerer);
        darkness3.setOwner(secondSorcerer);
        light2.setOwner(noCounterattackSorcerer);
        light3.setOwner(secondSorcerer);
        anima2.setOwner(noCounterattackSorcerer);
        anima3.setOwner(secondSorcerer);

    }

    public void setOtherTestUnits(){
        alpaca= new Alpaca(50,2,field.getCell(0,1));
        archer =new Archer(50,2,field.getCell(1,3));
        sorcerer2= new Sorcerer(50,2,field.getCell(0,2));
        sorcerer3= new Sorcerer(50,2,field.getCell(0,3));
        cleric =new Cleric(50,2,field.getCell(1,2));
        fighter =new Fighter(50,2,field.getCell(2,3));
        hero =new Hero(50,2,field.getCell(2,4));
        swordMaster =new SwordMaster(50,2,field.getCell(2,8));
    }

    @Override
    @Test
    public void gameChangerTest() {
        assertFalse(secondSorcerer.gameChanger());
    }

    @Test
    @Override
    public void testUseEquippedItem() {

        //Sorcerer darkness
        //unidad desarmada vs unidad desarmada
        sorcerer.useEquippedItem(cleric);
        assertEquals(50,cleric.getCurrentHitPoints());
        assertEquals(1000,sorcerer.getCurrentHitPoints());
        secondSorcerer.equipItem(darkness3);
        //unidad principal desarmada
        secondSorcerer.useEquippedItem(sorcerer);
        assertEquals(990,sorcerer.getCurrentHitPoints());
        assertEquals(1,secondSorcerer.getCurrentHitPoints());

        equipWeapons();
        fighter.useEquippedItem(sorcerer);
        assertEquals(975,sorcerer.getCurrentHitPoints());
        assertEquals(35,fighter.getCurrentHitPoints());

        sorcerer2.useEquippedItem(sorcerer);
        assertEquals(960,sorcerer.getCurrentHitPoints());
        assertEquals(50,sorcerer2.getCurrentHitPoints());

        sorcerer3.useEquippedItem(sorcerer);
        assertEquals(960,sorcerer.getCurrentHitPoints());
        assertEquals(35,sorcerer3.getCurrentHitPoints());

        hero.useEquippedItem(sorcerer);
        assertEquals(945,sorcerer.getCurrentHitPoints());
        assertEquals(35,hero.getCurrentHitPoints());

        archer.useEquippedItem(sorcerer);
        assertEquals(930,sorcerer.getCurrentHitPoints());
        assertEquals(35,archer.getCurrentHitPoints());

        swordMaster.useEquippedItem(sorcerer);
        assertEquals(915,sorcerer.getCurrentHitPoints());
        assertEquals(35,swordMaster.getCurrentHitPoints());

        //ataque de unidad del mismo tipo
        secondSorcerer.useEquippedItem(sorcerer);
        assertEquals(905,sorcerer.getCurrentHitPoints());
        assertEquals(-9,secondSorcerer.getCurrentHitPoints());

        alpaca.useEquippedItem(sorcerer);
        assertEquals(905,sorcerer.getCurrentHitPoints());
        assertEquals(50,alpaca.getCurrentHitPoints());

        cleric.useEquippedItem(sorcerer);
        assertEquals(915,sorcerer.getCurrentHitPoints());

        //unidad con poca vida no logra contraatacar
        noCounterattackSorcerer.equipItem(darkness2);
        sorcerer.useEquippedItem(noCounterattackSorcerer);
        assertEquals(-9,noCounterattackSorcerer.getCurrentHitPoints());
        assertEquals(915,sorcerer.getCurrentHitPoints());

        //ataque de unidad fuera de combate
        noCounterattackSorcerer.useEquippedItem(sorcerer);
        assertEquals(915,sorcerer.getCurrentHitPoints());
        assertEquals(-9,noCounterattackSorcerer.getCurrentHitPoints());


        setUp();
        sorcerer.getLocation().setUnit(null);
        sorcerer2.getLocation().setUnit(null);
        sorcerer3.getLocation().setUnit(null);
        sorcerer= new Sorcerer(50,2,field.getCell(0,2));
        sorcerer2= new Sorcerer(1000,2,field.getCell(0,0));
        sorcerer3= new Sorcerer(50,2,field.getCell(0,3));
        //Sorcerer light
        //unidad desarmada vs unidad desarmada
        sorcerer2.useEquippedItem(cleric);
        assertEquals(50,cleric.getCurrentHitPoints());
        assertEquals(1000,sorcerer2.getCurrentHitPoints());

        secondSorcerer.equipItem(light3);
        //unidad principal desarmada
        secondSorcerer.useEquippedItem(sorcerer2);
        assertEquals(990,sorcerer2.getCurrentHitPoints());
        assertEquals(1,secondSorcerer.getCurrentHitPoints());

        equipWeapons();
        fighter.useEquippedItem(sorcerer2);
        assertEquals(975,sorcerer2.getCurrentHitPoints());
        assertEquals(35,fighter.getCurrentHitPoints());

        sorcerer.useEquippedItem(sorcerer2);
        assertEquals(975,sorcerer2.getCurrentHitPoints());
        assertEquals(35,sorcerer.getCurrentHitPoints());

        sorcerer3.useEquippedItem(sorcerer2);
        assertEquals(960,sorcerer2.getCurrentHitPoints());
        assertEquals(50,sorcerer3.getCurrentHitPoints());

        hero.useEquippedItem(sorcerer2);
        assertEquals(945,sorcerer2.getCurrentHitPoints());
        assertEquals(35,hero.getCurrentHitPoints());

        archer.useEquippedItem(sorcerer2);
        assertEquals(930,sorcerer2.getCurrentHitPoints());
        assertEquals(35,archer.getCurrentHitPoints());

        swordMaster.useEquippedItem(sorcerer2);
        assertEquals(915,sorcerer2.getCurrentHitPoints());
        assertEquals(35,swordMaster.getCurrentHitPoints());

        //ataque de unidad del mismo tipo
        secondSorcerer.useEquippedItem(sorcerer2);
        assertEquals(905,sorcerer2.getCurrentHitPoints());
        assertEquals(-9,secondSorcerer.getCurrentHitPoints());

        alpaca.useEquippedItem(sorcerer2);
        assertEquals(905,sorcerer2.getCurrentHitPoints());
        assertEquals(50,alpaca.getCurrentHitPoints());

        cleric.useEquippedItem(sorcerer2);
        assertEquals(915,sorcerer2.getCurrentHitPoints());

        //unidad con poca vida no logra contraatacar
        noCounterattackSorcerer.equipItem(light2);
        sorcerer2.useEquippedItem(noCounterattackSorcerer);
        assertEquals(-9,noCounterattackSorcerer.getCurrentHitPoints());
        assertEquals(915,sorcerer2.getCurrentHitPoints());

        //ataque de unidad fuera de combate
        noCounterattackSorcerer.useEquippedItem(sorcerer2);
        assertEquals(915,sorcerer2.getCurrentHitPoints());
        assertEquals(-9,noCounterattackSorcerer.getCurrentHitPoints());


        setUp();
        sorcerer.getLocation().setUnit(null);
        sorcerer2.getLocation().setUnit(null);
        sorcerer3.getLocation().setUnit(null);
        sorcerer= new Sorcerer(50,2,field.getCell(0,2));
        sorcerer2= new Sorcerer(50,2,field.getCell(0,3));
        sorcerer3= new Sorcerer(1000,2,field.getCell(0,0));
        //Sorcerer anima
        //unidad desarmada vs unidad desarmada
        sorcerer3.useEquippedItem(cleric);
        assertEquals(50,cleric.getCurrentHitPoints());
        assertEquals(1000,sorcerer3.getCurrentHitPoints());
        secondSorcerer.equipItem(anima3);
        //unidad principal desarmada
        secondSorcerer.useEquippedItem(sorcerer3);
        assertEquals(990,sorcerer3.getCurrentHitPoints());
        assertEquals(1,secondSorcerer.getCurrentHitPoints());

        equipWeapons();
        fighter.useEquippedItem(sorcerer3);
        assertEquals(975,sorcerer3.getCurrentHitPoints());
        assertEquals(35,fighter.getCurrentHitPoints());

        sorcerer2.useEquippedItem(sorcerer3);
        assertEquals(975,sorcerer3.getCurrentHitPoints());
        assertEquals(35,sorcerer2.getCurrentHitPoints());

        sorcerer.useEquippedItem(sorcerer3);
        assertEquals(960,sorcerer3.getCurrentHitPoints());
        assertEquals(50,sorcerer.getCurrentHitPoints());

        hero.useEquippedItem(sorcerer3);
        assertEquals(945,sorcerer3.getCurrentHitPoints());
        assertEquals(35,hero.getCurrentHitPoints());

        archer.useEquippedItem(sorcerer3);
        assertEquals(930,sorcerer3.getCurrentHitPoints());
        assertEquals(35,archer.getCurrentHitPoints());

        swordMaster.useEquippedItem(sorcerer3);
        assertEquals(915,sorcerer3.getCurrentHitPoints());
        assertEquals(35,swordMaster.getCurrentHitPoints());

        //ataque de unidad del mismo tipo
        secondSorcerer.useEquippedItem(sorcerer3);
        assertEquals(905,sorcerer3.getCurrentHitPoints());
        assertEquals(-9,secondSorcerer.getCurrentHitPoints());

        alpaca.useEquippedItem(sorcerer3);
        assertEquals(905,sorcerer3.getCurrentHitPoints());
        assertEquals(50,alpaca.getCurrentHitPoints());

        cleric.useEquippedItem(sorcerer3);
        assertEquals(915,sorcerer3.getCurrentHitPoints());

        //unidad con poca vida no logra contraatacar
        noCounterattackSorcerer.equipItem(anima2);
        sorcerer3.useEquippedItem(noCounterattackSorcerer);
        assertEquals(-9,noCounterattackSorcerer.getCurrentHitPoints());
        assertEquals(915,sorcerer3.getCurrentHitPoints());

        //ataque de unidad fuera de combate
        noCounterattackSorcerer.useEquippedItem(sorcerer3);
        assertEquals(915,sorcerer3.getCurrentHitPoints());
        assertEquals(-9,noCounterattackSorcerer.getCurrentHitPoints());
    }

    /**
     * @return the current unit being tested
     */



    @Test
    public void testGiveItem(){
        field.getCell(0,0).setUnit(null);
        field.getCell(0,1).setUnit(null);
        sorcerer=new Sorcerer(100,3,field.getCell(0,0),light,bow);
        fighter=new Fighter(100,3,field.getCell(0,1),darkness,bow,staff);
        assertTrue(fighter.getItems().contains(darkness));
        assertEquals(fighter,darkness.getOwner());
        assertTrue(!(sorcerer.getItems().contains(darkness)));

        fighter.giveItemTo(sorcerer,darkness);

        assertTrue(sorcerer.getItems().contains(darkness));
        assertEquals(sorcerer,darkness.getOwner());
        assertTrue(!(fighter.getItems().contains(darkness)));
    }

    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }


    @Test
    @Override
    public void equipAnimaTest() {
        anima.setOwner(sorcerer);
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(anima);
        assertEquals(anima, sorcerer.getEquippedItem());
    }

    @Test
    @Override
    public void equipLightTest() {
        light.setOwner(sorcerer);
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(light);
        assertEquals(light, sorcerer.getEquippedItem());
    }

    @Test
    @Override
    public void equipDarknessTest() {
        darkness.setOwner(sorcerer);
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(darkness);
        assertEquals(darkness, sorcerer.getEquippedItem());
    }

    @Test
    @Override
    public void equipAxeTest() {
        axe.setOwner(sorcerer);
        assertNull(sorcerer.getEquippedItem());
        Assertions.assertThrows(ClassCastException.class, () -> {
            sorcerer.equipItem(axe);
        });
    }

    @Test
    @Override
    public void equipSpearTest() {
        spear.setOwner(sorcerer);
        assertNull(sorcerer.getEquippedItem());
        Assertions.assertThrows(ClassCastException.class, () -> {
            sorcerer.equipItem(spear);
        });
    }

    @Test
    @Override
    public void equipSwordTest() {
        sword.setOwner(sorcerer);
        assertNull(sorcerer.getEquippedItem());
        Assertions.assertThrows(ClassCastException.class, () -> {
            sorcerer.equipItem(sword);
        });
    }

    @Test
    @Override
    public void equipStaffTest() {
        staff.setOwner(sorcerer);
        assertNull(sorcerer.getEquippedItem());
        Assertions.assertThrows(ClassCastException.class, () -> {
            sorcerer.equipItem(staff);
        });
    }

    @Test
    @Override
    public void equipBowTest() {
        bow.setOwner(sorcerer);
        assertNull(sorcerer.getEquippedItem());
        Assertions.assertThrows(ClassCastException.class, () -> {
            sorcerer.equipItem(bow);
        });
    }


}
