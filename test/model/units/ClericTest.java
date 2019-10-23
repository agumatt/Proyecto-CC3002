package model.units;

import model.items.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 */
public class ClericTest extends AbstractTestUnit {


  private Cleric deadCleric;
  private Cleric secondCleric;
  private Staff staff2;
  private Staff staff3;

  /**
   * Set up the main unit that's going to be tested in the test set
   */

  public void setTestUnit(){
    cleric = new Cleric(1000, 2, field.getCell(0, 0));
    deadCleric = new Cleric(-1, 2, field.getCell(1, 1));
    secondCleric = new Cleric(1, 2, field.getCell(2, 2));
    this.staff2 = new Staff("Staff", 10, 1, 5);
    this.staff3 = new Staff("Staff", 10, 1, 5);
    staff2.setOwner(deadCleric);
    staff3.setOwner(secondCleric);
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
  @Test
  public void gameChangerTest() {
    assertFalse(secondCleric.gameChanger());
  }

  @Test
  @Override
  public void testUseEquippedItem() {

    //unidad desarmada vs unidad desarmada
    cleric.useEquippedItem(archer);
    assertEquals(50,archer.getCurrentHitPoints());
    assertEquals(1000,cleric.getCurrentHitPoints());
    secondCleric.equipItem(staff3);
    //unidad principal desarmada
    secondCleric.useEquippedItem(cleric);
    assertEquals(1000,cleric.getCurrentHitPoints());
    assertEquals(1,secondCleric.getCurrentHitPoints());

    equipWeapons();
    sorcerer.useEquippedItem(cleric);
    assertEquals(985,cleric.getCurrentHitPoints());
    assertEquals(50,sorcerer.getCurrentHitPoints());

    sorcerer2.useEquippedItem(cleric);
    assertEquals(970,cleric.getCurrentHitPoints());
    assertEquals(50,sorcerer2.getCurrentHitPoints());

    sorcerer3.useEquippedItem(cleric);
    assertEquals(955,cleric.getCurrentHitPoints());
    assertEquals(50,sorcerer3.getCurrentHitPoints());

    hero.useEquippedItem(cleric);
    assertEquals(945,cleric.getCurrentHitPoints());
    assertEquals(50,hero.getCurrentHitPoints());

    fighter.useEquippedItem(cleric);
    assertEquals(935,cleric.getCurrentHitPoints());
    assertEquals(50,fighter.getCurrentHitPoints());

    swordMaster.useEquippedItem(cleric);
    assertEquals(925,cleric.getCurrentHitPoints());
    assertEquals(50,swordMaster.getCurrentHitPoints());

    archer.useEquippedItem(cleric);
    assertEquals(915,cleric.getCurrentHitPoints());
    assertEquals(50,archer.getCurrentHitPoints());

    //"ataque" de unidad del mismo tipo
    secondCleric.useEquippedItem(cleric);
    assertEquals(925,cleric.getCurrentHitPoints());
    assertEquals(1,secondCleric.getCurrentHitPoints());

    alpaca.useEquippedItem(cleric);
    assertEquals(925,cleric.getCurrentHitPoints());
    assertEquals(50,alpaca.getCurrentHitPoints());




    //"ataque" de unidad fuera de combate
    deadCleric.useEquippedItem(cleric);
    assertEquals(925,cleric.getCurrentHitPoints());
    assertEquals(-1,deadCleric.getCurrentHitPoints());

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
  public void equipAnimaTest() {
    anima.setOwner(cleric);
    assertNull(cleric.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      cleric.equipItem(anima);});
  }

  @Test
  @Override
  public void equipLightTest() {
    light.setOwner(cleric);
    assertNull(cleric.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      cleric.equipItem(light);});
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

  @Test
  @Override
  public void equipAxeTest() {
    axe.setOwner(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.equipItem(axe);
    assertNull(cleric.getEquippedItem());
  }


  @Test
  @Override
  public void equipSpearTest() {
    spear.setOwner(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.equipItem(spear);
    assertNull(cleric.getEquippedItem());
  }


  @Test
  @Override
  public void equipSwordTest() {
    sword.setOwner(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.equipItem(sword);
    assertNull(cleric.getEquippedItem());
  }

  @Test
  @Override
  public void equipStaffTest() {
    staff.setOwner(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.equipItem(staff);
    assertEquals(staff,cleric.getEquippedItem());
  }

  @Test
  @Override
  public void equipBowTest() {
    bow.setOwner(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.equipItem(bow);
    assertNull(cleric.getEquippedItem());
  }

}