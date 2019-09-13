package model.units;

import model.items.Axe;
import model.items.INonMagicalItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 */
public class FighterTest extends AbstractTestUnit {

  private Fighter noCounterattackFighter;
  private Fighter secondFighter;
  private Axe axe2;
  private Axe axe3;


  /**
   * Set up the main unit that's going to be tested in the test set
   */

  public void setTestUnit(){
    fighter = new Fighter(1000, 2, field.getCell(0, 0));
    noCounterattackFighter = new Fighter(1, 2, field.getCell(1, 1));
    secondFighter = new Fighter(1, 2, field.getCell(2, 2));
    this.axe2 = new Axe("Axe", 10, 1, 5);
    this.axe3 = new Axe("Axe", 10, 1, 5);
    axe2.setOwner(noCounterattackFighter);
    axe3.setOwner(secondFighter);
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

  @Override
  @Test
  public void testUseEquippedItem() {
    //unidad desarmada vs unidad desarmada
    fighter.useEquippedItem(cleric);
    assertEquals(50,cleric.getCurrentHitPoints());
    assertEquals(1000,fighter.getCurrentHitPoints());
    secondFighter.equipItem(axe3);
    //unidad principal desarmada
    secondFighter.useEquippedItem(fighter);
    assertEquals(990,fighter.getCurrentHitPoints());
    assertEquals(1,secondFighter.getCurrentHitPoints());

    equipWeapons();
    sorcerer.useEquippedItem(fighter);
    assertEquals(975,fighter.getCurrentHitPoints());
    assertEquals(35,sorcerer.getCurrentHitPoints());

    sorcerer2.useEquippedItem(fighter);
    assertEquals(960,fighter.getCurrentHitPoints());
    assertEquals(35,sorcerer2.getCurrentHitPoints());

    sorcerer3.useEquippedItem(fighter);
    assertEquals(945,fighter.getCurrentHitPoints());
    assertEquals(35,sorcerer3.getCurrentHitPoints());

    hero.useEquippedItem(fighter);
    assertEquals(945,fighter.getCurrentHitPoints());
    assertEquals(35,hero.getCurrentHitPoints());

    archer.useEquippedItem(fighter);
    assertEquals(935,fighter.getCurrentHitPoints());
    assertEquals(40,archer.getCurrentHitPoints());

    swordMaster.useEquippedItem(fighter);
    assertEquals(920,fighter.getCurrentHitPoints());
    assertEquals(50,swordMaster.getCurrentHitPoints());

    //ataque de unidad del mismo tipo
    secondFighter.useEquippedItem(fighter);
    assertEquals(910,fighter.getCurrentHitPoints());
    assertEquals(-9,secondFighter.getCurrentHitPoints());

    alpaca.useEquippedItem(fighter);
    assertEquals(910,fighter.getCurrentHitPoints());
    assertEquals(50,alpaca.getCurrentHitPoints());

    cleric.useEquippedItem(fighter);
    assertEquals(920,fighter.getCurrentHitPoints());

    //unidad con poca vida no logra contraatacar
    noCounterattackFighter.equipItem(axe2);
    fighter.useEquippedItem(noCounterattackFighter);
    assertEquals(-9,noCounterattackFighter.getCurrentHitPoints());
    assertEquals(920,fighter.getCurrentHitPoints());

    //ataque de unidad fuera de combate
    noCounterattackFighter.useEquippedItem(fighter);
    assertEquals(920,fighter.getCurrentHitPoints());
    assertEquals(-9,noCounterattackFighter.getCurrentHitPoints());


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
  public void equipAnimaTest() {
    anima.setOwner(fighter);
    assertNull(fighter.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      fighter.equipItem(anima);});
  }

  @Test
  @Override
  public void equipLightTest() {
    light.setOwner(fighter);
    assertNull(fighter.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      fighter.equipItem(light);});
  }

  @Test
  @Override
  public void equipDarknessTest() {
    darkness.setOwner(fighter);
    assertNull(fighter.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      fighter.equipItem(darkness);
    });
  }

  @Test
  @Override
  public void equipAxeTest() {
    axe.setOwner(fighter);
    assertNull(fighter.getEquippedItem());
    fighter.equipItem(axe);
    assertEquals(axe,fighter.getEquippedItem());
  }


  @Test
  @Override
  public void equipSpearTest() {
    spear.setOwner(fighter);
    assertNull(fighter.getEquippedItem());
    fighter.equipItem(spear);
    assertNull(fighter.getEquippedItem());
  }


  @Test
  @Override
  public void equipSwordTest() {
    sword.setOwner(fighter);
    assertNull(fighter.getEquippedItem());
    fighter.equipItem(sword);
    assertNull(fighter.getEquippedItem());
  }

  @Test
  @Override
  public void equipStaffTest() {
    staff.setOwner(fighter);
    assertNull(fighter.getEquippedItem());
    fighter.equipItem(staff);
    assertNull(fighter.getEquippedItem());
  }

  @Test
  @Override
  public void equipBowTest() {
    bow.setOwner(fighter);
    assertNull(fighter.getEquippedItem());
    fighter.equipItem(bow);
    assertNull(fighter.getEquippedItem());
  }

}