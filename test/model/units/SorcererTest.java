package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SorcererTest extends AbstractTestUnit {
    private Sorcerer sorcerer;
    private Alpaca alpaca;
    private Archer archer;
    private Cleric cleric;
    private Fighter fighter;
    private Hero hero;
    private SwordMaster swordMaster;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(25, 6, field.getCell(0, 0));
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
