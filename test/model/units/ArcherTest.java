package model.units;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test set for the Archer unit.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class ArcherTest extends AbstractTestUnit {

  private Archer weakArcher;
  private Archer deadArcher;

  /**
   * Set up the main unit that's going to be tested in the test set
   */

  public void setTestUnit(){
    archer = new Archer(1000, 2, field.getCell(0, 0));
    weakArcher = new Archer(1, 2, field.getCell(1, 1));
    deadArcher = new Archer(0, 2, field.getCell(2, 2));
  }




  public void setOtherTestUnits(){
    alpaca= new Alpaca(50,2,field.getCell(0,1));
    sorcerer =new Sorcerer(50,2,field.getCell(1,3));
    sorcerer2= new Sorcerer(50,2,field.getCell(0,2));
    sorcerer3= new Sorcerer(50,2,field.getCell(0,3));
    cleric =new Cleric(50,2,field.getCell(1,2));
    fighter =new Fighter(50,2,field.getCell(2,3));
    hero =new Hero(50,2,field.getCell(2,4));
    swordMaster =new SwordMaster(50,2,field.getCell(2,8));
  }

  @Override
  @Test
  public void testUseEquippedItem() {
      archer.useEquippedItem(cleric);
      assertEquals(50,cleric.getCurrentHitPoints());
      weakArcher.equipItem(bow);
      weakArcher.useEquippedItem(archer);
    assertEquals(990,archer.getCurrentHitPoints());

      equipWeapons();
    hero.useEquippedItem(archer);
    assertEquals(980,archer.getCurrentHitPoints());

    double dist=sorcerer2.getLocation().distanceTo(archer.getLocation());
    System.out.println(dist);
    assertTrue(dist==2);
    sorcerer2.useEquippedItem(archer);
    assertEquals(965,archer.getCurrentHitPoints());


  }


  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return archer;
  }

  /**
   * Checks if the bow is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipBowTest() {
    assertNull(archer.getEquippedItem());
    archer.equipItem(bow);
    assertEquals(bow, archer.getEquippedItem());
  }

  @Test
  @Override
  public void equipAnimaTest() {
    assertNull(archer.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      archer.equipItem(anima);
    });
  }

  @Test
  @Override
  public void equipLightTest() {
    assertNull(archer.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      archer.equipItem(light);
    });
  }

  @Test
  @Override
  public void equipDarknessTest() {
    assertNull(archer.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      archer.equipItem(darkness);
    });
  }
}