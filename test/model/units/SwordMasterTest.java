package model.units;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Ignacio Slater Muñoz
 */
public class SwordMasterTest extends AbstractTestUnit {



  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    swordMaster = new SwordMaster(50, 2, field.getCell(0, 0));
  }


  public void setOtherTestUnits(){
    alpaca= new Alpaca(50,2,field.getCell(0,1));
    archer =new Archer(50,2,field.getCell(1,1));
    cleric =new Cleric(50,2,field.getCell(1,2));
    fighter =new Fighter(50,2,field.getCell(2,3));
    hero =new Hero(50,2,field.getCell(2,4));
    sorcerer =new Sorcerer(50,2,field.getCell(2,8));
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
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipItem(sword);
    assertEquals(sword, swordMaster.getEquippedItem());
  }

  @Override
  public void equipAnimaTest() {
    assertNull(swordMaster.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      swordMaster.equipItem(anima);
    });
  }

  @Test
  @Override
  public void equipLightTest() {
    assertNull(swordMaster.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      swordMaster.equipItem(light);
    });
  }

  @Test
  @Override
  public void equipDarknessTest() {
    assertNull(swordMaster.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      swordMaster.equipItem(darkness);
    });
  }
}