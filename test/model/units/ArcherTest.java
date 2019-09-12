package model.units;

import model.items.Bow;
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

  private Archer noCounterattackArcher;
  private Archer secondArcher;
  private Bow bow2;
  private Bow bow3;

  /**
   * Set up the main unit that's going to be tested in the test set
   */

  public void setTestUnit(){
    archer = new Archer(1000, 2, field.getCell(0, 0));
    secondArcher = new Archer(1, 2, field.getCell(1, 1));
    noCounterattackArcher = new Archer(1, 2, field.getCell(2, 2));
    this.bow2 = new Bow("Bow", 10, 1, 2);
    this.bow3 = new Bow("Bow", 10, 1, 2);
    bow2.setOwner(noCounterattackArcher);
    bow3.setOwner(secondArcher);
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

    //unidad desarmada vs unidad desarmada
      archer.useEquippedItem(cleric);
      assertEquals(50,cleric.getCurrentHitPoints());
    assertEquals(1000,archer.getCurrentHitPoints());
      secondArcher.equipItem(bow3);
      //unidad principal desarmada
      secondArcher.useEquippedItem(archer);
    assertEquals(990,archer.getCurrentHitPoints());
    assertEquals(1,secondArcher.getCurrentHitPoints());

      equipWeapons();
    sorcerer.useEquippedItem(archer);
    assertEquals(975,archer.getCurrentHitPoints());
    assertEquals(35,sorcerer.getCurrentHitPoints());

    sorcerer2.useEquippedItem(archer);
    assertEquals(960,archer.getCurrentHitPoints());
    assertEquals(35,sorcerer2.getCurrentHitPoints());

    sorcerer3.useEquippedItem(archer);
    assertEquals(945,archer.getCurrentHitPoints());
    assertEquals(35,sorcerer3.getCurrentHitPoints());

    hero.useEquippedItem(archer);
    assertEquals(935,archer.getCurrentHitPoints());
    assertEquals(40,hero.getCurrentHitPoints());

    fighter.useEquippedItem(archer);
    assertEquals(925,archer.getCurrentHitPoints());
    assertEquals(40,fighter.getCurrentHitPoints());

    swordMaster.useEquippedItem(archer);
    assertEquals(915,archer.getCurrentHitPoints());
    assertEquals(40,swordMaster.getCurrentHitPoints());

    //ataque de unidad del mismo tipo
    secondArcher.useEquippedItem(archer);
    assertEquals(905,archer.getCurrentHitPoints());
    assertEquals(-9,secondArcher.getCurrentHitPoints());

    alpaca.useEquippedItem(archer);
    assertEquals(905,archer.getCurrentHitPoints());
    assertEquals(50,alpaca.getCurrentHitPoints());

    cleric.useEquippedItem(archer);
    assertEquals(915,archer.getCurrentHitPoints());

    //unidad con poca vida no logra contraatacar
    archer.useEquippedItem(noCounterattackArcher);
    assertEquals(-9,noCounterattackArcher.getCurrentHitPoints());
    assertEquals(915,archer.getCurrentHitPoints());

    //ataque de unidad fuera de combate
    noCounterattackArcher.useEquippedItem(archer);
    assertEquals(915,archer.getCurrentHitPoints());
    assertEquals(-9,noCounterattackArcher.getCurrentHitPoints());

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
    bow.setOwner(archer);
    assertNull(archer.getEquippedItem());
    archer.equipItem(bow);
    assertEquals(bow, archer.getEquippedItem());
  }

  @Test
  @Override
  public void equipAnimaTest() {
    anima.setOwner(archer);
    assertNull(archer.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      archer.equipItem(anima);
    });
  }

  @Test
  @Override
  public void equipLightTest() {
    light.setOwner(archer);
    assertNull(archer.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      archer.equipItem(light);
    });
  }

  @Test
  @Override
  public void equipDarknessTest() {
    darkness.setOwner(archer);
    assertNull(archer.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      archer.equipItem(darkness);
    });
  }
}