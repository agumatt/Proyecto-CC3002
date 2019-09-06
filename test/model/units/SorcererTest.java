package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SorcererTest extends AbstractTestUnit {


    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(50, 2, field.getCell(0, 0));
    }


    public void setOtherTestUnits(){
        alpaca= new Alpaca(50,2,field.getCell(0,1));
        archer =new Archer(50,2,field.getCell(1,1));
        cleric =new Cleric(50,2,field.getCell(1,2));
        fighter =new Fighter(50,2,field.getCell(2,3));
        hero =new Hero(50,2,field.getCell(2,4));
        swordMaster =new SwordMaster(50,2,field.getCell(2,8));
    }
    /**
     * @return the current unit being tested
     */

    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    /**
     * Checks if the axe is equipped correctly to the unit
     */
    @Test
    @Override
    public void equipAxeTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(axe);
        assertEquals(axe, sorcerer.getEquippedItem());
    }
}
