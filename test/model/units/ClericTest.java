package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class ClericTest extends AbstractTestUnit {


  private Cleric weakCleric;
  private Cleric deadCleric;

  /**
   * Set up the main unit that's going to be tested in the test set
   */

  public void setTestUnit(){
    cleric = new Cleric(50, 2, field.getCell(0, 0));
    weakCleric = new Cleric(50, 2, field.getCell(1, 1));
    deadCleric = new Cleric(50, 2, field.getCell(2, 2));
  }

  public void setOtherTestUnits(){
    alpaca= new Alpaca(50,2,field.getCell(0,1));
    archer =new Archer(50,2,field.getCell(1,3));
    sorcerer =new Sorcerer(50,2,field.getCell(1,2));
    sorcerer2= new Sorcerer(50,2,field.getCell(0,2));
    sorcerer3= new Sorcerer(50,2,field.getCell(0,3));
    fighter =new Fighter(50,2,field.getCell(2,3));
    hero =new Hero(50,2,field.getCell(2,4));
    swordMaster =new SwordMaster(50,2,field.getCell(2,8));
  }
  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return cleric;
  }

  @Test
  @Override
  public void equipStaffTest() {
    assertNull(cleric.getEquippedItem());
    cleric.equipItem(staff);
    assertEquals(staff, cleric.getEquippedItem());
  }

  @Override
  public void equipAnimaTest() {
    assertNull(cleric.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      cleric.equipItem(anima);
    });
  }

  @Test
  @Override
  public void equipLightTest() {
    assertNull(cleric.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      cleric.equipItem(light);
    });
  }

  @Test
  @Override
  public void equipDarknessTest() {
    assertNull(cleric.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      cleric.equipItem(darkness);
    });
  }
}