package model.units;

import model.items.Sword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    noCounterattackSwordMaster = new SwordMaster(1, 2, field.getCell(1, 1));
    secondSwordMaster = new SwordMaster(1, 2, field.getCell(2, 2));
    this.sword2 = new Sword("Sword", 10, 1, 5);
    this.sword3 = new Sword("Sword", 10, 1, 5);
    sword2.setOwner(noCounterattackSwordMaster);
    sword3.setOwner(secondSwordMaster);
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
  @Test
  public void gameChangerTest() {
    assertFalse(swordMaster.gameChanger());
  }

  @Test
  @Override
  public void testUseEquippedItem() {

    //unidad desarmada vs unidad desarmada
    swordMaster.useEquippedItem(cleric);
    assertEquals(50,cleric.getCurrentHitPoints());
    assertEquals(1000,swordMaster.getCurrentHitPoints());
    secondSwordMaster.equipItem(sword3);
    //unidad principal desarmada
    secondSwordMaster.useEquippedItem(swordMaster);
    assertEquals(990,swordMaster.getCurrentHitPoints());
    assertEquals(1,secondSwordMaster.getCurrentHitPoints());

    equipWeapons();
    sorcerer.useEquippedItem(swordMaster);
    assertEquals(975,swordMaster.getCurrentHitPoints());
    assertEquals(35,sorcerer.getCurrentHitPoints());

    sorcerer2.useEquippedItem(swordMaster);
    assertEquals(960,swordMaster.getCurrentHitPoints());
    assertEquals(35,sorcerer2.getCurrentHitPoints());

    sorcerer3.useEquippedItem(swordMaster);
    assertEquals(945,swordMaster.getCurrentHitPoints());
    assertEquals(35,sorcerer3.getCurrentHitPoints());

    hero.useEquippedItem(swordMaster);
    assertEquals(930,swordMaster.getCurrentHitPoints());
    assertEquals(50,hero.getCurrentHitPoints());

    fighter.useEquippedItem(swordMaster);
    assertEquals(930,swordMaster.getCurrentHitPoints());
    assertEquals(35,fighter.getCurrentHitPoints());

    archer.useEquippedItem(swordMaster);
    assertEquals(920,swordMaster.getCurrentHitPoints());
    assertEquals(40,archer.getCurrentHitPoints());

    //ataque de unidad del mismo tipo
    secondSwordMaster.useEquippedItem(swordMaster);
    assertEquals(910,swordMaster.getCurrentHitPoints());
    assertEquals(-9,secondSwordMaster.getCurrentHitPoints());

    alpaca.useEquippedItem(swordMaster);
    assertEquals(910,swordMaster.getCurrentHitPoints());
    assertEquals(50,alpaca.getCurrentHitPoints());

    cleric.useEquippedItem(swordMaster);
    assertEquals(920,swordMaster.getCurrentHitPoints());

    //unidad con poca vida no logra contraatacar
    noCounterattackSwordMaster.equipItem(sword2);
    archer.useEquippedItem(noCounterattackSwordMaster);
    assertEquals(-9,noCounterattackSwordMaster.getCurrentHitPoints());
    assertEquals(920,swordMaster.getCurrentHitPoints());

    //ataque de unidad fuera de combate
    noCounterattackSwordMaster.useEquippedItem(swordMaster);
    assertEquals(920,swordMaster.getCurrentHitPoints());
    assertEquals(-9,noCounterattackSwordMaster.getCurrentHitPoints());

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



  @Test
  @Override
  public void equipAxeTest() {
    axe.setOwner(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipItem(axe);
    assertNull(swordMaster.getEquippedItem());
  }


  @Test
  @Override
  public void equipSpearTest() {
    spear.setOwner(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipItem(spear);
    assertNull(swordMaster.getEquippedItem());
  }

  @Test
  @Override
  public void equipStaffTest() {
    staff.setOwner(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipItem(staff);
    assertNull(swordMaster.getEquippedItem());
  }

  @Test
  @Override
  public void equipBowTest() {
    bow.setOwner(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipItem(bow);
    assertNull(swordMaster.getEquippedItem());
  }

}