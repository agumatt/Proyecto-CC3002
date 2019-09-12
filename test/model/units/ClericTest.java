package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class ClericTest extends AbstractTestUnit {


  private Cleric noCounterattackCleric;
  private Cleric secondCleric;
  private Staff staff2;
  private Staff staff3;

  /**
   * Set up the main unit that's going to be tested in the test set
   */

  public void setTestUnit(){
    cleric = new Cleric(1000, 2, field.getCell(0, 0));
    noCounterattackCleric = new Cleric(50, 2, field.getCell(1, 1));
    secondCleric = new Cleric(50, 2, field.getCell(2, 2));
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

  @Override
  public void testUseEquippedItem() {

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
    staff.setOwner(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.equipItem(staff);
    assertEquals(staff, cleric.getEquippedItem());
  }

  @Override
  public void equipAnimaTest() {
    anima.setOwner(cleric);
    assertNull(cleric.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      cleric.equipItem(anima);
    });
  }

  @Test
  @Override
  public void equipLightTest() {
    light.setOwner(cleric);
    assertNull(cleric.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      cleric.equipItem(light);
    });
  }

  @Test
  @Override
  public void equipDarknessTest() {
    darkness.setOwner(cleric);
    assertNull(cleric.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      cleric.equipItem(darkness);
    });
  }
}