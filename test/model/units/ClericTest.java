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
    noCounterattackCleric = new Cleric(1, 2, field.getCell(1, 1));
    secondCleric = new Cleric(1, 2, field.getCell(2, 2));
    this.staff2 = new Staff("Staff", 10, 1, 5);
    this.staff3 = new Staff("Staff", 10, 1, 5);
    staff2.setOwner(noCounterattackCleric);
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
  public void testUseEquippedItem() {

    //unidad desarmada vs unidad desarmada
    cleric.useEquippedItem(archer);
    assertEquals(50,archer.getCurrentHitPoints());
    assertEquals(1000,cleric.getCurrentHitPoints());
    secondCleric.equipItem(staff3);
    //unidad principal desarmada
    secondCleric.useEquippedItem(cleric);
    assertEquals(1000,archer.getCurrentHitPoints());
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