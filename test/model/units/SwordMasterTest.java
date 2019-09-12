package model.units;

import model.items.Sword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Ignacio Slater Muñoz
 */
public class SwordMasterTest extends AbstractTestUnit {



  private SwordMaster noCounterattackSwordMaster;
  private SwordMaster secondSwordMaster;
  private Sword sword2;
  private Sword sword3;

  /**
   * Set up the main unit that's going to be tested in the test set
   */

  public void setTestUnit(){
    swordMaster = new SwordMaster(1000, 2, field.getCell(0, 0));
    noCounterattackSwordMaster = new SwordMaster(50, 2, field.getCell(1, 1));
    secondSwordMaster = new SwordMaster(50, 2, field.getCell(2, 2));
  }



  public void setOtherTestUnits(){
    alpaca= new Alpaca(50,2,field.getCell(0,1));
    archer =new Archer(50,2,field.getCell(1,3));
    cleric =new Cleric(50,2,field.getCell(1,2));
    fighter =new Fighter(50,2,field.getCell(2,3));
    hero =new Hero(50,2,field.getCell(2,4));
    sorcerer =new Sorcerer(50,2,field.getCell(2,8));
    sorcerer2= new Sorcerer(50,2,field.getCell(0,2));
    sorcerer3= new Sorcerer(50,2,field.getCell(0,3));
  }

  @Override
  public void testUseEquippedItem() {

  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return swordMaster;
  }

  @Override
  @Test
  public void equipSwordTest() {
    sword.setOwner(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipItem(sword);
    assertEquals(sword, swordMaster.getEquippedItem());
  }

  @Override
  public void equipAnimaTest() {
    anima.setOwner(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      swordMaster.equipItem(anima);
    });
  }

  @Test
  @Override
  public void equipLightTest() {
    light.setOwner(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      swordMaster.equipItem(light);
    });
  }

  @Test
  @Override
  public void equipDarknessTest() {
    darkness.setOwner(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      swordMaster.equipItem(darkness);
    });
  }
}