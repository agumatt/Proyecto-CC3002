package model.units;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SorcererTest extends AbstractTestUnit {


    private Sorcerer weakSorcerer;
    private Sorcerer deadSorcerer;

    /**
     * Set up the main unit that's going to be tested in the test set
     */

    public void setTestUnit(){
        sorcerer = new Sorcerer(50, 2, field.getCell(0, 0));
        weakSorcerer = new Sorcerer(50, 2, field.getCell(1, 1));
        deadSorcerer = new Sorcerer(50, 2, field.getCell(2, 2));
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
    public void testUseEquippedItem() {

    }

    /**
     * @return the current unit being tested
     */

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
