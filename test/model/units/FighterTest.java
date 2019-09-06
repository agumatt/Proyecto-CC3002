package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class FighterTest extends AbstractTestUnit {

  private Fighter weakFighter;
  private Fighter deadFighter;

  /**
   * Set up the main unit that's going to be tested in the test set
   */

  public void setTestUnit(){
    fighter = new Fighter(50, 2, field.getCell(0, 0));
    weakFighter = new Fighter(50, 2, field.getCell(1, 1));
    deadFighter = new Fighter(50, 2, field.getCell(2, 2));
  }

  public void setOtherTestUnits(){
    alpaca= new Alpaca(50,2,field.getCell(0,1));
    archer =new Archer(50,2,field.getCell(1,3));
    cleric =new Cleric(50,2,field.getCell(1,2));
    sorcerer =new Sorcerer(50,2,field.getCell(2,3));
    sorcerer2= new Sorcerer(50,2,field.getCell(0,2));
    sorcerer3= new Sorcerer(50,2,field.getCell(0,3));
    hero =new Hero(50,2,field.getCell(2,4));
    swordMaster =new SwordMaster(50,2,field.getCell(2,8));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return fighter;
  }

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipAxeTest() {
    assertNull(fighter.getEquippedItem());
    fighter.equipItem(axe);
    assertEquals(axe, fighter.getEquippedItem());
  }

  @Override
  public void equipAnimaTest() {
    assertNull(fighter.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      fighter.equipItem(anima);
    });
  }

  @Test
  @Override
  public void equipLightTest() {
    assertNull(fighter.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      fighter.equipItem(light);
    });
  }

  @Test
  @Override
  public void equipDarknessTest() {
    assertNull(fighter.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      fighter.equipItem(darkness);
    });
  }
}